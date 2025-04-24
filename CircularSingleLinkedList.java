package neetcode.linkedList;

import neetcode.linkedList.circularDoubleLinkedList.Node;

public class CircularSingleLinkedList {
    public Node head;
    public Node tail;
    public int size;
    public Node createCssl(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    public static void main(String[] args) {
        CircularSingleLinkedList cssl = new CircularSingleLinkedList();
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(2);
        System.out.println(dll.head.value);
        cssl.createCssl(5);
        System.out.println(cssl.head.value);
        System.out.println(cssl.head.next.value);
    }
}
