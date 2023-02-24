public class LinkedMap<KeyType, ValueType> {
    private class Node {
        KeyType key;
        ValueType value;
        Node next;
    }

    // fields
    private Node head;

    public void put(KeyType thekey, ValueType theValue) {
        // is theKey in the map already?
        Node current = head;
        while (current != null) {
            if (thekey.equals(current.key)) {
                // I found it!
                current.value = theValue;
                return; // we are done, end the method
            }
            // move the current forward to the next node
            current = current.next;
        }

        // if not, add it
        // add a new node to represent the key-value pair
        Node theNewNode = new Node();
        theNewNode.key = thekey;
        theNewNode.value = theValue;
        theNewNode.next = head;
        head = theNewNode;
        // added the newNode at the front of the list

    }

    public ValueType get(KeyType theKey) {
        Node current = head;
        while (current != null) {
            if (theKey.equals(current.key)) {
                // I found the key!
                return current.value;
            }
        }

        // get to the end of the loop
        // key not in the list
        return null;
    }
}

