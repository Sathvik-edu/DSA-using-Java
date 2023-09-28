package DataStructures.Heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeapInsert {
    private List<Integer> heap;

    public MinHeapInsert() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }



    // WRITE THE INSERT METHOD HERE //
    public void insert(int value) {
        // Add the new value to the end of the heap
        heap.add(value);

        // Set the index of the newly added value
        int current = heap.size() - 1;

        // While the current node has a parent and the current node's value
        // is less than its parent's value...
        while (current > 0 && heap.get(current) < heap.get(parent(current))) {

            // ...swap the current node with its parent to maintain
            // the heap property (parent nodes have values less than
            // or equal to their children)
            swap(current, parent(current));

            // Move to the parent node for the next iteration
            current = parent(current);
        }
    }


}



