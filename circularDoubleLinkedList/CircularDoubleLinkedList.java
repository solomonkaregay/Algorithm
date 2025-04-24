package neetcode.linkedList.circularDoubleLinkedList;

import neetcode.linkedList.circularDoubleLinkedList.DoubleCircleNode;

import java.security.spec.RSAOtherPrimeInfo;

public class CircularDoubleLinkedList {
    public DoubleCircleNode head;
    public DoubleCircleNode tail;
    public int size;

    // create CDLL
    public DoubleCircleNode createCDLL(int nodeValue) {
        head = new DoubleCircleNode();
        DoubleCircleNode newNode = new DoubleCircleNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 1;
        return head;
    }

    public void insertCDLL(int nodeValue, int location) {
        DoubleCircleNode newNode = new DoubleCircleNode();
        newNode.value = nodeValue;
        if (head == null) {
            createCDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;

        } else if (location >= size) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoubleCircleNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            newNode.next.prev = newNode;
        }
        size++;
    }

    // traverse Cdll
    public void traverseCDll() {
        if (head != null) {
            DoubleCircleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("The CDLL does not exist.");
        }
        System.out.println();
    }

    // reverse Traverse
    public void reverseTraverse() {
        if (head != null) {
            DoubleCircleNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
        } else {
            System.out.print("The CDLL does not exist");
        }
    }

    // search
    public boolean searchCDLL(int nodeValue) {
        if (head != null) {
            DoubleCircleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("The node found at index of: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("The node does not found");
        return false;
    }

    // deleting node
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The node does not exist");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
                return;
            }
        } else if (location >= size) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            }

        } else {
            DoubleCircleNode tempNode = head;
            for (int i = 0; i < location; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    // delete CDLL
    public void deleteCDLL() {
        DoubleCircleNode tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
            tail = null;
            head = null;
            System.out.println("The Entire CDLL has been deleted");
    }
}
