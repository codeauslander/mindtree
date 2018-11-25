// Java Dequeue
// https://www.hackerrank.com/challenges/java-dequeue/problem
import java.util.*;

public class test {
    // public static class Queue<T>{
    //     private Stack<T> newest = new Stack<T>();
    //     private Stack<T> oldest = new Stack<T>();

    //     public void enqueue(T value){
    //         // add item
    //         newest.push(value);
    //     }
    //     public T peek(){
    //         // get oldest item
    //         // move from newest
    //         shiftStacks();
    //         return oldest.peek();
    //     }
    //     public T dequeue(){
    //         // get oldest item and remove it
    //         // move from newest
    //         shiftStacks();
    //         return oldest.pop(); 
    //     }
    //     private void shiftStacks(){
    //         if(oldest.isEmpty()){
    //             while(!newest.isEmpty()){
    //                 oldest.push(newest.pop());
    //             }
    //         }
    //     }
    // }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int unique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            //  System.out.println(n+","+m+","+unique+","+num+","+i);
            if( i == 0){
                deque.add(num);
                unique ++;
            } else {
                if(deque.size() == m){
                    deque.removeFirst();
                }
                if(!deque.contains(num) && unique < m){
                    unique ++;
                }
                deque.addLast(num);
            }
        }
        System.out.println(unique);
    }
}
