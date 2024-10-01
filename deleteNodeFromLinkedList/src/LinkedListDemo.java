
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class with methods to handle node deletion
class LinkedList {
    Node head;

    // Method to add a node at the end of the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to delete a node by its value
    public void deleteNode(int key) {
        if (head == null) { // Case 1: If the list is empty
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // Case 2: If the node to delete is at the beginning (head)
        if (head.data == key) {
            head = head.next; // Move the head to the next node
            System.out.println("Node with value " + key + " deleted from the beginning.");
            return;
        }

        // Traversing the list to find the node to delete
        Node current = head;
        Node previous = null;
        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        // Case 3: If the node doesn't exist in the list
        if (current == null) {
            System.out.println("Node with value " + key + " not found.");
            return;
        }

        // Case 4: If the node to delete is at the end
        if (current.next == null) {
            previous.next = null;
            System.out.println("Node with value " + key + " deleted from the end.");
            return;
        }

        // Case 5: Deleting a node in the middle
        previous.next = current.next;
        System.out.println("Node with value " + key + " deleted from the list.");
    }
}

// Main class to test the linked list deletion
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding nodes to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original List:");
        list.printList();

        // Deleting the head
        list.deleteNode(10);
        list.printList();

        // Deleting a node from the middle
        list.deleteNode(30);
        list.printList();

        // Deleting the tail node
        list.deleteNode(40);
        list.printList();

        // Trying to delete a node that doesn't exist
        list.deleteNode(50);
        list.printList();
    }
}
