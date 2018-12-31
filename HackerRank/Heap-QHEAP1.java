// https://www.hackerrank.com/challenges/qheap1/problem
import java.util.Scanner;

class Heap {
    int length = 0;
    int size = 0;
    int[] array = null;
    public Heap() {
        this.length = 100000;
        this.size = 0;
        array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MAX_VALUE;
        }
    }
}
public class Solution {
    static int left(int i) {
        return 2 * i;
    }
    static int right(int i) {
        return (2 * i) + 1;
    }
    static void exchange(Heap heap, int i, int j) {
        final int temporary = heap.array[i];
        heap.array[i] = heap.array[j];
        heap.array[j] = temporary;
    }
    static void heapify(Heap heap, int i) {
        int smallestIndex = 0;
        int leftIndex = left(i);
        int rightIndex = right(i);
        if ((leftIndex <= heap.size) && (heap.array[leftIndex] < heap.array[i])) {
            smallestIndex = leftIndex;
        } else {
            smallestIndex = i;
        }
        if ((rightIndex <= heap.size) && (heap.array[rightIndex] < heap.array[smallestIndex])) {
            smallestIndex = rightIndex;
        }
        if (smallestIndex != i) {
            exchange(heap, i, smallestIndex);
            heapify(heap, smallestIndex);
        }
    }
    static int search(Heap heap, int item) {
        for (int i = 1; i <= heap.size; i++) {
            if (heap.array[i] == item) {
                return i;
            }
        }
        System.out.println("<<< item: " + item + " NOT found !!!");
        return -1;
    }
    static void minHeap(Heap heap) {
        for (int index = (heap.size / 2); index > 0; index--) {
            heapify(heap, index);
        }
    }
    static void add(Heap heap, int item) {
        heap.size += 1;
        heap.array[heap.size] = item;
        minHeap(heap);
    }
    static void delete(Heap heap, int item) {
        int i = search(heap, item);
        if (i < -1) {
            System.out.println("<<< UNEXPECTED i: " + i + " item: " + item);
            return;
        }
        heap.array[i] = Integer.MAX_VALUE;
        exchange(heap, i, heap.size);
        heap.size--;
        minHeap(heap);
    }
    static void print(Heap heap) {
        System.out.println(heap.array[1]);
    }
    static void dump(Heap heap) {
        System.out.print("<<< ");
        for (int i = 1; i <= heap.size; i++) {
            System.out.print(heap.array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int item = -1;
        int typeQuery = -1;
        Heap heap = new Heap();
        Scanner input = new Scanner(System.in);
        int amountQueries = input.nextInt();
        for (int queryNumber = 0; queryNumber < amountQueries; queryNumber++) {
            typeQuery = input.nextInt();
            if (typeQuery < 3) {
                item = input.nextInt();
            }
            switch (typeQuery) {
            case 1:
                add(heap, item);
                break;
            case 2:
                delete(heap, item);
                break;
            case 3:
                print(heap);
                break;
            }
        }
       input.close();
    }
}

