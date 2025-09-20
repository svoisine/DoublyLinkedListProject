/*
 * Class DoublyLinkedList
 *
 * This class uses generics to create a Doubly Linked Sorted List Object.
 * As well as creates methods that can be called on the lists.
 * 
 * Name: Seth Voisine
 * UGA ID: 811906637
 * Date: 09/20/2025
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;

    /*
     * This method constructs the doubly linked list.
     * 
     * param - none
     * 
     * @return - none
     */
    public DoublyLinkedList() {
        this.head = null;
    }

    /*
     * This method inserts <item> into the DLL, while maintaining original sorted
     * order
     * 
     * param - T item
     * 
     * @return - void
     */
    public void insertItem(T item) {

        NodeType<T> value = new NodeType<>();
        value.info = item;

        // list is empty
        if (head == null) {
            head = value;
            return;
        }

        // insert it at the first value
        if (item.compareTo(head.info) < 0) {
            value.next = head;
            head.back = value;
            head = value;
            return;
        }

        NodeType<T> temp = head;

        // find value
        while (temp.next != null && item.compareTo(temp.next.info) > 0) {
            temp = temp.next;
        }

        // if value is in the list already
        if (temp.info.compareTo(item) == 0 || (temp.next != null && temp.next.info.compareTo(item) == 0)) {
            System.out.println("Item already exists");
            return;
        }

        // otherwise insert it into the list
        value.next = temp.next;
        if (temp.next != null) {
            temp.next.back = value;
        }
        value.back = temp;
        temp.next = value;
    }

    /*
     * This method deletes <item> from the DLL, while maintaining the original
     * sorted order
     * 
     * param - T item
     * 
     * @return - void
     */
    public void deleteItem(T item) {
        // empty list
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        }

        NodeType<T> temp = head;

        // if first value is the value to delete
        if (temp.info.compareTo(item) == 0) {
            head = head.next;
            // this makes sure we're not looking at an empty list once you move head up
            if (head != null) {
                head.back = null;
            }
            return;
        }

        // loop to find the value
        while (temp != null && temp.info.compareTo(item) != 0) {
            temp = temp.next;
        }

        // if you loop to the end of the list
        if (temp == null) {
            System.out.println("The item is not present in the list");
            return;
        }

        // Delete the item; but also check for cases of null already being present
        if (temp.back != null) {
            temp.back.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.back = temp.back;
        }
    }

    /*
     * This method loops through the list to find the length, then returns said
     * length
     * 
     * param - none
     * 
     * @return int
     */
    public int length() {

        // empty list
        if (head == null) {
            return 0;
        }

        int len = 0;
        NodeType<T> temp = head;

        // find the length of the current list
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }

        return len;
    }

    /*
     * This method prints the values in the list
     * 
     * param - none
     * 
     * @return - void
     */
    public void print() {
        NodeType<T> temp = head;
        String s = "";
        while (temp != null) {
            s += String.valueOf(temp.info) + " ";
            temp = temp.next;
        }
        System.out.println(s);
    }

    /*
     * This method prints the reverse order of the list
     * 
     * param - none
     * 
     * @return - void
     */
    public void printReverse() {
        NodeType<T> temp = head;
        String s = "";

        if (head == null) {
            System.out.println(s);
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            s += String.valueOf(temp.info) + " ";
            temp = temp.back;
        }
        System.out.println(s);
    }

    /*
     * This method loopes through the DLL and finds the values between the lower
     * and upper
     * bounds inside the list and removes them from the list.
     * 
     * 
     * param - T lowerBound, T upperBound
     * 
     * @return - void
     */
    public void deleteSubsection(T lowerBound, T upperBound) {

        // if empty list just print out a blank space as the list
        if (head == null) {
            return;
        }

        // create two holder values that will be used to set the bounds in the list
        NodeType<T> tempLower = head;
        NodeType<T> tempUpper = head;

        // loop twice so you can find the both values needed
        while (tempLower != null && tempLower.info.compareTo(lowerBound) < 0) {
            tempLower = tempLower.next;
        }

        // if no values you inbetween lower and upper
        if (tempLower == null) {
            return;
        }

        tempUpper = tempLower;

        while (tempUpper != null && tempUpper.info.compareTo(upperBound) <= 0) {
            tempUpper = tempUpper.next;
        }

        // case where you delete from the head until the upper
        if (tempLower == head) {
            head = tempUpper;
            if (head != null) {
                head.back = null;
            }
            return;
        }

        // base case
        NodeType<T> beforeLower = tempLower.back;
        beforeLower.next = tempUpper;
        if (tempUpper != null) {
            tempUpper.back = beforeLower;
        }

    }

    /*
     * This method reverses the DLL without creating a new list. This function
     * maintains a
     * time complexity of O(n) and a space complexity of O(1).
     * 
     * param - none
     * 
     * @return NodeType<T>
     */
    public NodeType<T> reverseList() {
        NodeType<T> temp = head;
        NodeType<T> prev = null;
        while (temp != null) {
            NodeType<T> nextVal = temp.next;
            temp.next = prev;
            temp.back = nextVal;

            prev = temp;
            temp = nextVal;
        }

        if (prev != null) {
            head = prev;
        }

        return head;
    }

    /*
     * This method swaps every 2 value pairs ([1,2,3,4,5,6]) <-- 1 & 2 swap, 3 & 4
     * swap, and so on
     * 
     * param - none
     * 
     * @return - void
     */
    public void swapAlternate() {

        // if the list is empty or has one value in it
        if (head == null || head.next == null) {
            return;
        }

        NodeType<T> temp = head;
        head = head.next;

        while (temp != null && temp.next != null) {
            NodeType<T> firstVal = temp;
            NodeType<T> secondVal = temp.next;
            NodeType<T> nextPair = secondVal.next;

            secondVal.back = firstVal.back;
            if (secondVal.back != null) {
                secondVal.back.next = secondVal;
            }

            firstVal.next = nextPair;
            if (nextPair != null) {
                nextPair.back = firstVal;
            }

            secondVal.next = firstVal;
            firstVal.back = secondVal;

            temp = nextPair;
        }

    }

}
