// https://www.hackerrank.com/challenges/qheap1/problem

// https://www.hackerrank.com/challenges/qheap1/problem
import java.util.Scanner;

class Heap {

    int length = 0;

    int heapSize = 0;

    int[] arr = null;

    public Heap() {

        this.length = 100000;

        this.heapSize = 0;

        arr = new int[length];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = Integer.MAX_VALUE;

        }

    }

}

public class Solution {

    // **** methods ****

    static int left(int i) {

        return 2 * i;

    }

    static int right(int i) {

        return (2 * i) + 1;

    }

    static void exchange(Heap heap, int i, int j) {

        int temp = heap.arr[i];

        heap.arr[i] = heap.arr[j];

        heap.arr[j] = temp;

    }

    static void heapify(Heap heap, int i) {

        int smallest = 0;

        int l = left(i);

        int r = right(i);

        // **** determine if smallest is on left … ****

        if ((l <= heap.heapSize) && (heap.arr[l] < heap.arr[i])) {

            smallest = l;

        } else {

            smallest = i;

        }

        // **** … or smallest is on right ****

        if ((r <= heap.heapSize) && (heap.arr[r] < heap.arr[smallest])) {

            smallest = r;

        }

        // **** exchange if needed ****

        if (smallest != i) {

            exchange(heap, i, smallest);

            heapify(heap, smallest);

        }

    }

static int search(Heap heap, int v) {

for (int i = 1; i <= heap.heapSize; i++) {

if (heap.arr[i] == v) {

return i;

}

}

System.out.println("<<< v: " + v + " NOT found !!!");

return -1;

}

static void minHeap(Heap heap) {

for (int pos = (heap.heapSize / 2); pos >= 1; pos--) {

heapify(heap, pos);

}

}

    static void add(Heap heap, int v) {

        heap.heapSize += 1;

        heap.arr[heap.heapSize] = v;

        minHeap(heap);

    }

static void delete(Heap heap, int v) {

int i = search(heap, v);

if (i <= 0) {

System.out.println("<<< UNEXPECTED i: " + i + " v: " + v);

return;

}

heap.arr[i] = Integer.MAX_VALUE;

exchange(heap, i, heap.heapSize);

heap.heapSize--;

minHeap(heap);

}

    static void print(Heap heap) {

        System.out.println(heap.arr[1]);

    }

static void dump(Heap heap) {

System.out.print("<<< ");

for (int i = 1; i <= heap.heapSize; i++) {

System.out.print(heap.arr[i] + " ");

}

System.out.println();

}

    public static void main(String[] args) {

        int v = -1;

        int query = -1;

        Heap heap = new Heap();

        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();

        // **** loop once per query ****

        for (int q = 0; q < Q; q++) {

            query = sc.nextInt();

            if (query <= 2) {

                v = sc.nextInt();

            }

            switch (query) {

            case 1:

                add(heap, v);

                break;

            case 2:

                delete(heap, v);

                break;

            case 3:

                print(heap);

                break;

            }

        }

        // **** ****

        sc.close();

    }

}