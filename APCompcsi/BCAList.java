public interface BCAList<E> {

    /**
     * Appends the specified element to the end of this list.
     */
    public void add(E e);

    /**
     * Inserts the specified element at the specified position in this list.
     * Existing elements in the list are shifted right. If the specified index is
     * at the end of list, the specified element is appended to the end of the
     * list.
     *
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public void add(int index, E e);

    /**
     * Removes all of the elements from this list. This method releases all
     * references to elements stored in the list so that they can be garbage
     * collected.
     */
    public void clear();

    /**
     * Returns true if this list contains the specified element.
     */
    public boolean contains(E e);

    /**
     * Returns the element at the specified position in this list.
     *
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public E get(int index);


    /**
     * Replaces the element at the specified position in this list with the
     * specified element.  Returns the value previously stored at the location.
     *
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public E set(int index, E e);


    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     */
    public int indexOf(E e);

    /**
     * Returns true if this list contains no elements.
     */
    public boolean isEmpty();

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element.
     */
    public int lastIndexOf(E e);

    /**
     * Removes the element at the specified position in this list.
     *
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public E remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present.
     *
     * @return true if an element is removed, false otherwise.
     */
    public boolean remove(E e);

    /**
     * Returns the number of elements in this list.
     */
    public int size();

    /**
     * Used for debugging.  Prints every element in the list along with its index.  For example,
     * assume the list contains the values 15, 19, 12.
     * toString should return the following string: "0: 15; 1: 19; 2: 12;"
     */
    public String toString();
}
