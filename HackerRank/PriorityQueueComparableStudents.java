// Java Priority Queue
// https://www.hackerrank.com/challenges/java-priority-queue/problem

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student>{
    int id;
    String name;
    double cgpa;
    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int compareTo(Student b){
        if( this.cgpa == b.cgpa ){
            int nameOrder = this.name.compareTo(b.name);
            if( nameOrder == 0 ){
                return this.id - b.id;
            }
            return nameOrder;
        }
        return b.cgpa - this.cgpa > 0 ? 1 : -1;
    }
    public String getName(){
        return this.name;
    }

}

class Priorities{
    Priorities(){};
    public List<Student> getStudents(List<String> events){
        PriorityQueue<Student> queue = new PriorityQueue<Student>();
        for(int i = 0; i < events.size(); i++){
            if(events.get(i).contains("SERVED")){
                if(queue.size() > 0){ queue.poll(); }
            } else {
                String[] data = events.get(i).split(" ");
                queue.add(new Student(Integer.parseInt(data[3]), data[1], Double.valueOf(data[2])));
            }
        }
        List<Student> result = new ArrayList<>();
        while(queue.size() > 0){
            result.add(queue.poll());
        }
        return result;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}