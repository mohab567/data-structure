package eg.edu.alexu.csd.datastructure.queue;
/**
 * @author DELL
 *
 */
public interface IQueue {
/**
*@param item Inserts an item at the queue front.
*/
void enqueue(Object item);
/**
* @return Removes the object at the queue rear and returns it.
*/
Object dequeue();
/**
*@return Tests if this queue is empty.
*/
boolean isEmpty();
/**
* @return the number of elements in the queue
*/
int size();
}
