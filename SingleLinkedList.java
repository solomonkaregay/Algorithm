package neetcode.linkedList;

import neetcode.linkedList.circularDoubleLinkedList.Node;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node creatingLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // insert linkedList
    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            creatingLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // traverse In LinkedList
    public void traverseInLinkedList() {
        if (head == null) {
            System.out.println("SSl does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.println(tempNode.value);
                if (i != size - 1) {
                    System.out.println("->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    // search for Node in LinkedList
    public boolean searchLinkedList(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location:" + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("node not found! ");
        return false;
    }

    public void deletingLinkedList(int location) {
        if (head == null) {
            System.out.println("The SSl doesn't found ");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {
            Node tempNode = new Node();
            for (int i = 0; i < size; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // delete LinkedList
    public void deleteSSL() {
        if (head == null) {
            System.out.println("the linkedList does not found");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("successfully deleted the LinkedList");
        }
    }

    public static void main(String[] args) {
        SingleLinkedList sl = new SingleLinkedList();
        sl.creatingLinkedList(5);
        System.out.println(sl.head.value);
        sl.insertLinkedList(6, 1);
        sl.insertLinkedList(7, 3);
        sl.insertLinkedList(8, 4);
        sl.insertLinkedList(9, 0);
        sl.traverseInLinkedList();
        //sl.searchLinkedList(6);
        sl.deletingLinkedList(4);
        sl.traverseInLinkedList();
        sl.deleteSSL();
        //System.out.println(sl.head.next.next.value);
    }
}
