package utils;

public class ArrayListTest {

    public static void main(String[] args) {
        testAddAndToString();
        testAddAtIndex();
        testAddAll();
        testContains();
        testRemoveByIndex();
        testRemoveByItem();
        testRemoveAll();
        testClear();
        testSizeAndIsEmpty();
    }

    private static void testAddAndToString() {
        System.out.println("\nTesting add() and toString():");
        ArrayList<String> list = new ConcreteArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        System.out.println("list: " + list); // Expected: [apple, banana, cherry]
    }

    private static void testAddAtIndex() {
        System.out.println("\nTesting add(index, item):");
        ArrayList<String> list = new ConcreteArrayList<>();
        list.add("apple");
        list.add("cherry");
        list.add(1, "banana");
        System.out.println("list: " + list); // Expected: [apple, banana, cherry]
    }

    private static void testAddAll() {
        System.out.println("\nTesting addAll():");
        ArrayList<String> list1 = new ConcreteArrayList<>();
        list1.add("apple");
        list1.add("banana");

        ArrayList<String> list2 = new ConcreteArrayList<>();
        list2.add("cherry");
        list2.add("date");

        list1.addAll(list2);
        System.out.println("list1: " + list1); // Expected: [apple, banana, cherry, date]
    }

    private static void testContains() {
        System.out.println("\nTesting contains():");
        ArrayList<String> list = new ConcreteArrayList<>();
        list.add("apple");
        list.add("banana");

        System.out.println("Contains 'apple': " + list.contains("apple")); // Expected: true
        System.out.println("Contains 'cherry': " + list.contains("cherry")); // Expected: false
    }

    private static void testRemoveByIndex() {
        System.out.println("\nTesting remove(index):");
        ArrayList<String> list = new ConcreteArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        list.remove(1); // Remove "banana"
        System.out.println("list after removal: " + list); // Expected: [apple, cherry]
    }

    private static void testRemoveByItem() {
        System.out.println("\nTesting remove(item):");
        ArrayList<String> list = new ConcreteArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        list.remove("banana"); // Remove "banana" by item
        System.out.println("list after removing 'banana': " + list); // Expected: [apple, cherry]

        boolean removed = list.remove("grape"); // Attempt to remove a nonexistent item
        System.out.println("Removed nonexistent item 'grape': " + removed); // Expected: false
    }

    private static void testRemoveAll() {
        System.out.println("\nTesting removeAll():");
        ArrayList<String> list1 = new ConcreteArrayList<>();
        list1.add("apple");
        list1.add("banana");
        list1.add("cherry");

        ArrayList<String> list2 = new ConcreteArrayList<>();
        list2.add("apple");
        list2.add("cherry");

        list1.removeAll(list2); // Should remove "apple" and "cherry"
        System.out.println("list1 after removeAll: " + list1); // Expected: [banana]
    }

    private static void testClear() {
        System.out.println("\nTesting clear():");
        ArrayList<String> list = new ConcreteArrayList<>();
        list.add("apple");
        list.add("banana");

        list.clear(); // Clear all elements
        System.out.println("list after clear: " + list); // Expected: []
    }

    private static void testSizeAndIsEmpty() {
        System.out.println("\nTesting size() and isEmpty():");
        ArrayList<String> list = new ConcreteArrayList<>();
        System.out.println("Is empty: " + list.isEmpty()); // Expected: true

        list.add("apple");
        System.out.println("Size after adding one element: " + list.size()); // Expected: 1

        list.clear();
        System.out.println("Size after clear: " + list.size()); // Expected: 0
        System.out.println("Is empty after clear: " + list.isEmpty()); // Expected: true
    }
}