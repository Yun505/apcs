package day5;

public class BCABinaryTree <E extends Comparable<E>>  {
    BCATreeNode<E> root = null;

    public BCABinaryTree(){

    }

    public boolean insert(E e){
        BCATreeNode<E> newNode = new BCATreeNode<>(e);

        if (root == null){
            root = newNode;
            return true;
        }

        BCATreeNode<E> parent = root;
        BCATreeNode<E> current = root;

        while (current != null){
            int compare = e.compareTo(current.element);

            if (compare == 0){
                return false;
            }

            // e < current.element
            else if (compare < 0){
                parent = current;
                current = current.left;
            }

            // e > current.element
            else{
                parent = current;
                current = current.right;
            }
        }

        if (e.compareTo(parent.element) < 0){
            parent.left = newNode;
        }
        else{
            parent.right = newNode;
        }
        return true; 
    }

    public E getMinimum(){
        BCATreeNode<E> c = root;

        if (c == null){
            return null;
        }
    
        while (c.left != null){
            c = c.left;
        }
        return c.element;
    }

    public E getMaximum(){
        BCATreeNode<E> c = root;

        if (c == null){
            return null;
        }
    
        while (c.right != null){
            c = c.right;
        }
        return c.element;
    }

    public void inorder(){
        inorder(root);
    }

    private void inorder(BCATreeNode<E> node){
        if(node.left != null){
            inorder(node.left);
        }

        System.out.println(node.element);
        if (node.right != null){
            inorder(node.right);
        }
    }

    public void preorder(){
        preorder(root);
    }

    private void preorder(BCATreeNode<E> node){
        System.out.println(node.element);

        if(node.left != null){
            preorder(node.left);
        }
        
        if (node.right != null){
            preorder(node.right);
        }
    }

    public void postorder(){
        postorder(root);
    }

    private void postorder(BCATreeNode<E> node){
        if(node.left != null){
            postorder(node.left);
        }
        
        if (node.right != null){
            postorder(node.right);
        }
        System.out.println(node.element);
    }
}
