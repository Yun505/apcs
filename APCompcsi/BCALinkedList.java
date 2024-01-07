public class BCALinkedList<E> implements BCAList<E> {

    protected Node<E> head = null;
    protected Node<E> tail = null;
    protected int listSize = 0;

    public BCALinkedList() {        
    }

    @Override
    public void add(E e) {
        add(listSize, e);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Out of bounds.");
        }

        Node<E> newNode = new Node<>(e);

        if (index == 0) {
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
        }

        else if (index == listSize) {
            tail.next = newNode;
            tail = newNode;
        }

        else {
            Node<E> n = head;
            for (int i=1; i<index; i++) {
                n = n.next;
            }
            newNode.next = n.next;
            n.next = newNode; 
        }
        listSize++;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        listSize = 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> n = head;
        for (int i=0; i<index; i++) {
            n = n.next;
        }
        return n.data;
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> n = head;
        for (int i=0; i<index; i++) {
            n = n.next;
        }
        E ret = n.data;
        n.data = e;
        
        return ret;
    }

    @Override
    public int indexOf(E e) {
        Node<E> n = head;
        int index = 0;
        while (n != null) {
            if (n.data.equals(e)) {
                return index;
            }
            n = n.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> n = head;
        int ret = -1;
        int index = 0;
        while (n != null) {
            if (n.data.equals(e)) {
                ret = index;
            }
            n = n.next;
            index++;
        }
        return ret;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException();
        }
        E retVal = null;

        if (listSize == 1) {
            retVal = head.data;
            head = null;
            tail = null;
        }
        else if (index == 0) {
            retVal = head.data;
            head = head.next;
        }
        else {
            Node<E> n = head;
            for (int i=0; i<index-1;i++) {
                n = n.next;                
            }
            retVal = n.next.data;

            n.next = n.next.next;

            if (n.next == null) {
                tail = n;
            }
        }

        listSize-=1;
        return retVal;
    }

    @Override
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }

    @Override
    public int size() {
        return listSize;
    }
    
    public String toString() {
        String out = "";
        Node<E> n = head;
        int i  = 0;

        while (n != null) {
            out += i + ": " + n.data + "; ";
            n = n.next;
            i++;
        }

        return out;
    }
}


class Node<E> {
    E data = null;
    Node<E> next = null;

    public Node (E e) {
        data = e;
    }
}