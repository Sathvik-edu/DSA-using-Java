package DataStructures.Heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeapSink {
    private List<Integer> heap;

    public MinHeapSink() {
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

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // WRITTEN THE SINKDOWN METHOD HERE //
    private void sinkDown(int index) {
        // Start with the current index node as the minIndex
        int minIndex = index;

        // Continuously sink down the node until it's in the correct position
        while (true) {

            // Find indices of left and right children
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            // If left child exists and is smaller than the current min, update minIndex
            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }

            // If right child exists and is smaller than the current min, update minIndex
            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }

            // If the minIndex is not equal to the index, it means one of the child nodes is
            // smaller than the current node and we need to swap them
            if (minIndex != index) {
                swap(index, minIndex);

                // The index now becomes the minIndex (position of child node we swapped with)
                index = minIndex;
            }
            // If the minIndex is still equal to the index, it means the current node is smaller
            // than its children, so it's in the correct position and we can exit the loop
            else {
                return;
            }
        }
    }



    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int minValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return minValue;
    }

}





