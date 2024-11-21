package n1exercise1;

import n1exercise1.manager.Manager;
import n1exercise1.sampleData.SampleData;

public class Main {
    public static void main(String[] args) {
        SampleData sampleData = new SampleData();
        Manager manager = sampleData.run();

        manager.printArrayList();
        manager.printHashSet();
        manager.printLinkedHashSet();
        manager.printLinkedHashSetWithIterator();
    }
}