package utils;

public class ArrayListTest {

    public static void main(String[] args) {
        // Create an ArrayList of Integers
        ArrayList<Integer> intList = new ArrayList<Integer>() {
            @Override
            public boolean remove(Integer item) {
                int index = indexOf(item);
                if (index == -1) return false;
                remove(index);
                return true;
            }
        };

        // Test add() method
        System.out.println("Testing add() method:");
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println("Expected: [10, 20, 30]");
        System.out.println("Actual: " + intList);
        System.out.println();

        // Test get() method
        System.out.println("Testing get() method:");
        System.out.println("Expected: 20");
        System.out.println("Actual: " + intList.get(1));
        System.out.println();

        // Test size() method
        System.out.println("Testing size() method:");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + intList.size());
        System.out.println();

        // Test remove() method
        System.out.println("Testing remove() method:");
        intList.remove(1); // Removes element at index 1 (which is 20)
        System.out.println("Expected: [10, 30]");
        System.out.println("Actual: " + intList);
        System.out.println();

        // Test contains() method
        System.out.println("Testing contains() method:");
        System.out.println("Expected: true");
        System.out.println("Actual: " + intList.contains(10));
        System.out.println("Expected: false");
        System.out.println("Actual: " + intList.contains(20));
        System.out.println();

        // Test clear() method
        System.out.println("Testing clear() method:");
        intList.clear();
        System.out.println("Expected: []");
        System.out.println("Actual: " + intList);
        System.out.println("Expected size: 0");
        System.out.println("Actual size: " + intList.size());
    }
}


