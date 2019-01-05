import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int lengthHead1 = 0, lengthHead2 = 0;
        SinglyLinkedListNode current1 = head1, current2 = head2;
        while (current1 != null) {
            current1 = current1.next;
            lengthHead1++;
        }
        while (current2 != null) {
            current2 = current2.next;
            lengthHead2++;
        }
        while (lengthHead1 > lengthHead2) {
            head1 = head1.next;
            lengthHead1--;
        }
        while (lengthHead2 > lengthHead1) {
            head2 = head2.next;
            lengthHead2--;
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        if(head1 == head2 && head1 != null){
            return head1.data;
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);