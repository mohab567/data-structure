package eg.edu.alexu.csd.datastructure.linkedList;
/**
 * @author DELL
 *
 */
public interface ILinkedList {
/**
*@param index term number
*@param element data
* Inserts a specified element at the specified sposition in the list.
*/
void add(int index, Object element);
/** Inserts the specified element at the end of the list.
*@param element data
*/
void add(Object element);
/** Returns the element at the specified position in this list.
*@param index term number
*@return data
*/
Object get(int index);
/**
* Replaces the element at the specified position in this list with
* the specified element.
*@param index term number
*@param element data
*/
void set(int index, Object element);
/** Removes all of the elements from this list. */
void clear();
/** Returns true if this list contains no elements.
*@return boalean
*/
boolean isEmpty();
/** Removes the element at the specified position in this list.
*@param index term number
*/
void remove(int index);
/** Returns the number of elements in this list.
*@return number of terms
*/
int size();
/**
* Returns a view of the portion of this list between the specified
* fromIndex and toIndex, inclusively.
*@param fromIndex start
*@param toIndex data
*@return sublist
*/
ILinkedList sublist(int fromIndex, int toIndex);
/**
* Returns true if this list contains an element with the same value
* as the specified element.
* @param o data
* @return boalean
*/
boolean contains(Object o);
}