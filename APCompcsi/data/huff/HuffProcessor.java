package data.huff;

import java.util.PriorityQueue;

/**
 * Created by bryres on 4/20/2017.
 */
public class HuffProcessor implements Processor {

    @Override
    public void compress(BitInputStream in, BitOutputStream out) {
        // Count the frequency of each character (0-255) from the file.
        int[] counts = readForCounts(in);

        // For debugging purposes, print the count array.
        printCounts(counts);

        // Create the trie from the frequency table
        HuffNode root = makeTreeFromCounts(counts);

        // For debugging purposes, print the encoded tree to System.out
        printEncodingTree(root, 1);

        // Traverse the tree to determine the compressed encoding for each character.
        String[] codings = makeCodingsFromTree(root);

        // For debugging purposes, print the encodings array.
        printCodingsArray(codings);

        // Traverse the tree to record the encodings in the output file.
        writeHeader(root, out);

        // Debugging output to System.out
        int headerBits = out.getBitsWritten();
        System.out.println("Header out.  Total bits: " + headerBits);

        // Go back to the beginning of the input file
        in.reset();

        // Write the body of the compressed file, followed by EOF.
        writeCompressedBits (in, codings, out);

        // Make sure all bits have been physically written to the file.
        out.flush();

        // Debugging output to System.out
        int bodyBits = out.getBitsWritten() - headerBits;
        System.out.println("Body out.  Total bits: " + bodyBits);

    }

    /** Returns an array [0-255] that represents the frequency of each byte value in
     * the input file. */
    private int[] readForCounts(BitInputStream in)
    {
        //Step 1
        int[] array = new int[256];
        int i = in.readBits(8);
        while (i != -1){
            array[i] += 1;
            i = in.readBits(8); 
        }
        return array;
    }


    /** Debugging method.
     * Prints the counts in the array.
     * */
    public void printCounts (int[] counts) {
        for (int i=0; i<counts.length; i++) {
            if (counts[i] > 0) {
                System.out.printf("%d (%c): %d\n", i, i > 32 ? i : ' ', counts[i]);
            }
        }
    }

    /** Uses the array from readForCounts and returns a HuffNode that's
     * the root of the Huffman coding tree. Use a priority queue to create
     * the tree, as we did in class.  Be sure to create a count of one for
     * PSEUDO_EOF and include it in the priority queue (and tree) as well.
     */
    private HuffNode makeTreeFromCounts(int[] array) {
        // Step 2
        PriorityQueue<HuffNode> new_huff = new PriorityQueue<HuffNode>();
        for (int i = 0; i < array.length; i ++){
            if (array[i] > 0){
                new_huff.add(new HuffNode(i, array[i]));
            }
        }
        new_huff.add(new HuffNode(PSEUDO_EOF, 1));

        while(new_huff.size() > 1){
            HuffNode left = new_huff.remove();
            HuffNode right = new_huff.remove();
            HuffNode a = new HuffNode(-1, left.weight() + right.weight(), left, right);
            new_huff.add(a); 
        }
        HuffNode root = new_huff.remove(); 
        return root;
    }

    /** Debugging method.
     * This is very similar to the prior lab.  I am providing the implementation so that our trees
     * have a consistent appearance. */
    private void printEncodingTree(HuffNode n, int indent) {
        if (n.isLeaf()) {
            System.out.printf("%" + indent + "s", "");
            String val = n.value() == PSEUDO_EOF ? "EOF" : "" + (char)n.value();
            System.out.println("\'" + val + "\'");
        }
        else {
            System.out.printf("%" + indent + "sL\n", "");
            printEncodingTree(n.left(), indent + 2);

            System.out.printf("%" + indent + "sR\n", "");
            printEncodingTree(n.right(), indent + 2);
        }
    }

    /** Returns an array [0-256] -- note extra space for the EOF character
     * which has a value of 256.  Each position in the array includes a String
     * of 0's and 1's indicating the compressed encoding for the byte.  In
     * order to determine these encodings, a preorder traversal of the tree is
     * used.  Each left traversal adds a "0" to the encoding.  Each right
     * traversal adds a "1" to the encoding.  When a leaf is reached, the
     * current encoding is added to the array.*/

    private String[] makeCodingsFromTree(HuffNode root) {
        //made it return 
        //Step 3! You will need to create a helper recursive method
        String[] a = new String[257];
        String s = "";
        makeCodingsFromTrees(root, a, s);
        return a;
    }

    //recursive function
    private String[] makeCodingsFromTrees(HuffNode n, String[] b, String s){
        if (n.left() == null  && n.right() == null){
            //EOF
            b[n.value()] = s;
        }
        else{
            makeCodingsFromTrees(n.left(), b, s + "0");
            makeCodingsFromTrees(n.right(), b, s + "1");
        }
        return b;
    }

    /** Debugging method.
     * Prints the codings of the characters in the array [0-256].
     * */
    public void printCodingsArray (String[] codings) {
        for (int i=0; i<256; i++) {
            if (codings[i] != null) {
                System.out.printf("%d (%c): %s\n", i, i > 32 ? i : ' ', codings[i]);
            }
        }
        System.out.printf("256 (EOF): %s\n", codings[PSEUDO_EOF]);

    }

    /** Writes the bits for the header to the output stream.
     * Traverse the tree using preorder traversal.
     * For each internal node, write "0" to the output and traverse left and right.
     * For each leaf, write "1" to the output followed by the 9 bit representation of
     * the value stored in the leaf.
     */
    private void writeHeader (HuffNode n, BitOutputStream out)
    {
        //Step 4
        if (n.left() == null && n.right() == null){
            out.writeBits(1, 1);
            out.writeBits(9, n.value());
            return;
        }
        else{
        out.writeBits(1, 0);
        //recursion till base case
        writeHeader(n.left(), out);
        writeHeader(n.right(), out);
        }
    }

    /** Write the body of the compressed file.  Read through the input stream 8 bits
     * at time.  Look up the encoding for that byte from "codings".  Write that
     * encoding to the output stream using the following, which interprets the String
     * as a binary number to convert it to an int and then writes the correct number
     * of bits to represent that number to output:
     *         int code = Integer.parseInt(strCode, 2);
     *         out.writeBits(strCode.length(), code);
     * After reading through all of "in", write PSEUDO_EOF as a final encoded
     * character to the file.
     */
    private void writeCompressedBits(BitInputStream in, String[] codings, BitOutputStream out)
    {
        //Step 5
        int val = in.readBits(8);
        while(val != -1){
            String a = codings[val]; 
            out.writeBits(a.length(), Integer.parseInt(a, 2));
            val = in.readBits(8);
        }
        String a = codings[PSEUDO_EOF]; 
        out.writeBits(a.length(), Integer.parseInt(a, 2));
        //out.writeBits(PSEUDO_EOF , Integer.parseInt(codings[PSEUDO_EOF], 2));
    }


    @Override
    public void decompress(BitInputStream in, BitOutputStream out) {
        // Reads the encoding of the trie from the beginning of in.
        HuffNode root = readHeader(in);

        // Debugging method -- print the tree.
        printEncodingTree(root, 1);

        // Read the body of the compressed file.
        readCompressedBits(root, in, out);
        out.flush();
    }

    /** Reads the header of the compressed file and returns encoding trie.
     * This method uses a recursion.  The algorithm is:
     * Read one bit from the input.
     * If the bit is a 0, recurse left and right, creating two new HuffNodes.  Then,
     * return a new HuffNode with the left and right nodes as the new node's children.
     * If the bit is a 1, read 9 bits from the input and create a HuffNode using these bits.
     * The weight of the HuffNodes does not matter during decompression and can be set to -1.
     */
    HuffNode readHeader (BitInputStream in)
    {
        //Step 6
        int val = in.readBits(1);
        if(val == 1){
            int nine = in.readBits(9);
            HuffNode new_huff = new HuffNode(nine, -1);
            return new_huff;
        }
        else{
            HuffNode left = readHeader(in);
            HuffNode right = readHeader(in);
            return new HuffNode(0, 0, left, right);
        }
        
    }

    /** Reads the body of the compressed file.  Start at the root of the tree.
     * Read 1 bit of input.
     * If the bit is a 0, traverse left.  If 1, traverse right.
     * If we are now pointing to a leaf, write the value of the leaf to output.  Go
     * back to the top of the tree and traverse again.
     * (If the value of the leaf is PSEUDO_EOF, exit the function.)
     */
    private void readCompressedBits(HuffNode root, BitInputStream in, BitOutputStream out)
    {
        //Step 7
        HuffNode a = root;
        int val = in.readBits(1);
        while(val != -1){
            if (val == 0){
                a = a.left();
            }
            else{
                a = a.right();
            }
            
            if (a.left() == null && a.right() == null){
                if(a.value() == PSEUDO_EOF){
                    break;
                }
                out.writeBits(8, a.value());
                a = root;
            }
            val = in.readBits(1);
            
        }

    }


}
