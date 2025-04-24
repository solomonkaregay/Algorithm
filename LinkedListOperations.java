package neetcode.linkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Paris");
        cities.add("Canada");
        cities.add("US");
        cities.add("China");
        System.out.println("Initial LinkedList: " + cities);
        cities.addFirst("Tigray");
        cities.addLast("Ethiopia");
        cities.remove("Paris");
        cities.remove(2);
        System.out.println("Initial LinkedList: " + cities);
        for(String s : cities){
            System.out.println(s);
        }
        Iterator<String> r = cities.iterator();
        while(r.hasNext()){
            System.out.println(r.next());
        }
    }
}
