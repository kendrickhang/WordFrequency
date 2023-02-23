/**
 * LinkedMap class - includes put and get methods.
 *
 * @author Jasmine David
 */
public class LinkedMap<KeyType, ValueType> {
    private class Node {
        KeyType key;
        ValueType value;
        Node next;

    }

    // fields
    private Node head;

    /**
     * This method inserts Key and Value pairs into a Linked Map object
     * @param theKey - key
     * @param theValue - value
     */
    public void put(KeyType theKey, ValueType theValue) {
        // if theKey in  the map already
        Node current = head;
        while (current != null) {
            if(theKey.equals(current.key)){
                current.value = theValue;
                return; // we are done, end method
            }
            // move current forward to the next node
            current = current.next;
        }
        // if not, add it
        // add a new node to represent the key-value pair
        Node theNewNode = new Node();
        theNewNode.key = theKey;
        theNewNode.value = theValue;
        theNewNode.next = head;
        head = theNewNode;
        // added the new node
    }

    /**
     * This method returns the Value of a given Key.
     * @param theKey - key
     * @return Value
     */
    public ValueType get(KeyType theKey) {
        Node current = head;
        while (current != null) {
            if (theKey.equals(current.key)) {
                // I found the key!
                return current.value;
            }
        }
        // get to the end of the loop
        // key is not in the list
        return null;

    }

}
