package neetcode.linkedList;

import neetcode.linkedList.circularDoubleLinkedList.Node;

public class DeleteSingleLinkedList {
    Node head;
    Node tail;
    int length;
    public boolean deleteLinkedListByValue(int value) {
        if (this.length == 0) {
            return false;
        }
        if (this.head == this.tail && this.head.value == value) {
            this.head = null;
            this.tail = null;
            this.length = 0;
            return true;
        }
        Node current = this.head;
        Node prev = null;
        do {
            if (current.value == value) {
                if (current == this.head) {
                    this.head = this.head.next;
                    this.tail.next = this.head;

                } else if (current == this.tail) {
                    prev.next = this.head;
                    this.tail = prev;
                } else {
                    prev.next = current.next;
                }
                this.length--;
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != this.head);
            return false;
        }
        public int countNode(){
        int count = 0;
        Node temp = this.head;
        if(temp == null) {
            return 0;
        }
        do{
            count++;
            temp = temp.next; // move to the next node
        } while (temp!= this.head);
        return count;
        }
    }

