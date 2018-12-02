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
      Scanner sc = new Scanner(System.in);
      Deque<Integer> dq = new ArrayDeque<Integer>();
      HashSet<Integer> s = new HashSet<Integer>();
      int n = sc.nextInt();
      int m = sc.nextInt();
      int max = 0;
      for (int i = 0; i < n; i++) {
        int tmp = sc.nextInt();
        dq.add(tmp);
        s.add(tmp);
    
        if (dq.size() == m) {
          max = Math.max(s.size(), max);
          int item = dq.remove();
          if (!dq.contains(item)) {
            s.remove(item);
          }
        }
      }
      System.out.println(max);
      sc.close();
    }
}
