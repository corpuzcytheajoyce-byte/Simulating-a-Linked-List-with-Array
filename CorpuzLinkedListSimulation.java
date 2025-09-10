/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package corpuzlinkedlistsimulation;

// Name: [Cythea Joyce L. Corpuz]
// Section: [BSIT - 2B]
// Date: 2025-09-08

public class CorpuzLinkedListSimulation {
    private int[] array;
    private int size; // current number of elements
    private static final int INITIAL_CAPACITY = 5;

    // Constructor
    public CorpuzLinkedListSimulation() {
        array = new int[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds a new element at the end of the array.
     * If the array is full, it resizes to accommodate more elements.
     */
    public void add(int value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

    /**
     * Removes and returns the first element (like poll in queue).
     * Shifts the remaining elements to the left.
     * Returns -1 if the array is empty.
     */
    public int poll() {
        if (size == 0) {
            return -1; // array is empty
        }
        int first = array[0];
        for (int i = 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return first;
    }

    /**
     * Returns the first element without removing it.
     * Returns -1 if the array is empty.
     */
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return array[0];
    }

    /**
     * Removes and returns the last element (like pop in stack).
     * Returns -1 if the array is empty.
     */
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int last = array[size - 1];
        size--;
        return last;
    }

    /**
     * Helper method to resize the array when it's full.
     */
    private void resize() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /**
     * Prints the current elements in the array.
     */
    public void printArray() {
        System.out.print("Current array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the class
    public static void main(String[] args) {
        ArrayLinkedListSimulation list = new ArrayLinkedListSimulation();

        // Test add
        System.out.println("Adding elements:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.printArray();

        // Test poll
        System.out.println("Poll: " + list.poll());
        list.printArray();

        // Test peek
        System.out.println("Peek: " + list.peek());
        list.printArray();

        // Test pop
        System.out.println("Pop: " + list.pop());
        list.printArray();

        // Add more elements to trigger resize
        list.add(60);
        list.add(70);
        list.add(80);
        list.printArray();

        // Final state
        System.out.println("Final peek: " + list.peek());
        System.out.println("Final pop: " + list.pop());
        list.printArray();
    }
}