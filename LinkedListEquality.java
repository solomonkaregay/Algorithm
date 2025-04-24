package neetcode.linkedList;

import java.util.LinkedList;

public class LinkedListEquality {
    public static void main(String[] args) {
        // Create two LinkedLists
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(4);
        list3.add(5);
        list3.add(6);

        // Check if list1 and list2 are equal
        if (list1.equals(list2)) {
            System.out.println("list1 and list2 are equal.");
        } else {
            System.out.println("list1 and list2 are not equal.");
        }

        // Check if list1 and list3 are equal
        if (list1.equals(list3)) {
            System.out.println("list1 and list3 are equal.");
        } else {
            System.out.println("list1 and list3 are not equal.");
        }
    }
}
