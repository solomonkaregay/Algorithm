package neetcode.linkedList.circularDoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.createCDLL(1);
        cdll.insertCDLL(2,1);
        cdll.insertCDLL(3,2);
        cdll.insertCDLL(4,5);
        cdll.traverseCDll();
        cdll.deleteNode(6);
        cdll.traverseCDll();
        cdll.deleteCDLL();
        //cdll.reverseTraverse();
        System.out.println(cdll.head.value);
    }
}
