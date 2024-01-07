package day5;

public class BCATreeTester {
    public static void main(String[] args) {
        BCABinaryTree<String> tree = new BCABinaryTree<>();

        tree.insert("Tal");
        tree.insert("Daniel");
        tree.insert("Hayun");
        tree.insert("Maggie");
        tree.insert("Annie");

        System.out.println("Max: " + tree.getMaximum());

        tree.inorder();

        System.out.println("\n\nPre-order");
        tree.preorder();

        System.out.println("\n\nPost-order");
        tree.postorder();
    }
    
}
