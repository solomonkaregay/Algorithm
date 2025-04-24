package neetcode.linkedList;

public class DoublyLinkedList {

    DoublyNode head;
    DoublyNode tail;
    int size;

    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.prev = null;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }
    // insertion method
    public void insertDDL(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }
    //traverse DDL

    public void traverseDDL() {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("the DDl does not found");
        }
        System.out.println("\n");
    }

    // Reverse Traverse
    public void reverseTraverseDDL() {
        if (head != null) {
            DoublyNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
        } else {
            System.out.print("the DDl does not found");
        }
        System.out.println("\n");

    }
    // Search Node in DDl

    public boolean searchNodeDDL(int nodeValue) {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("The Node found at location :" + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }
        // Deletion of Node from DDl
        public void deleteNodeDDL(int location) {
            if (head == null) {
                System.out.print("the DDL does not exist ");
                return;
            } else if (location == 0) {
                if (size == 1) {
                    head = null;
                    tail = null;
                    size--;
                    return;
                } else {
                    head = head.next;
                    head.prev = null;
                    size--;
                }
            } else if (location >= size) {
                DoublyNode tempNode = tail.prev;
                if (size == 1) {
                    head = null;
                    tail = null;
                    size--;
                    return;
                } else {
                    tempNode.next = null;
                    tail = tempNode;
                    size--;
                }
            } else {
                DoublyNode tempNode = head;
                for (int i = 0; i < location - 1; i++) {
                    tempNode = tempNode.next;
                }
                tempNode.next = tempNode.next.next;
                tempNode.next.prev = tempNode;
                size--;
            }
        }
            // delete the entire DDl
            public void deleteDDL () {
                DoublyNode tempNode = head;
                for (int i = 0; i < size; i++) {
                    tempNode.prev = null;
                    tempNode = tempNode.next;
                }
                head = null;
                tail = null;
                size--;
                System.out.println("the DDl has been deleted ");
            }

    public static void main(String[] args) {
        DoublyLinkedList ddl = new DoublyLinkedList();
        ddl .createDLL(1);
        ddl.insertDDL(2,0);
        ddl.insertDDL(3,1);
        ddl.insertDDL(4,7);
        //ddl.traverseDDL();
        // ddl.reverseTraverseDDL();
        //ddl.searchNodeDDL(4);
        //ddl.deleteNodeDDL(2);
        ddl.traverseDDL();
        ddl.deleteDDL();
        ddl.traverseDDL();
        //System.out.println(ddl.head.next.value);
    }
}
