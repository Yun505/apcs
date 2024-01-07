public class BCAArrayList<E> implements BCAList<E> {
    protected Object[] array = new Object[5];
    protected int listSize = 0;

    public BCAArrayList() {

    }

    private void expand() {
        Object[] na = new Object[array.length*2];
        for (int i=0; i<array.length; i++) {
            na[i] = array[i];
        }
        array = na;
    }

    @Override
    public void add(E e) {
        if (listSize >= array.length) {
            expand();
        }
        array[listSize++] = e;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (listSize >= array.length) {
            expand();
        }
        for (int i = listSize - 1; i>=index; i--) {
            array[i+1]= array[i];
        }
        array[index] = e;
        listSize++;
    }

    @Override
    public void clear() {
        for (int i=0; i<listSize;i++) {
            array[i] = null;
        }
        listSize=0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return (E)array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E e) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        
        E t = (E)array[index];
        
        array[index] = e;
     
        return t;
    }

    @Override
    public int indexOf(E e) {
        for (int i=0; i<listSize; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i=listSize-1; i>=0; i--) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E ret = (E)array[index];

        for (int i=index; i<listSize-1; i++) {
            array[i] = array[i+1];
        }

        array[listSize-1] = null;

        listSize--;

        return ret;
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

        for (int i=0; i<listSize; i++) {
            out += i + ": " + array[i] + "; ";
        }

        return out;
    }
    
}
