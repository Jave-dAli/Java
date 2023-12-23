package Building_LinkedList;

import java.util.NoSuchElementException;

public class linkedList {
    private class Node {
        private int value;
        private Node next;
        Node(int value){
            this.value=value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // addFirst
    public void addFirst(int item){
        Node node=new Node(item);
        if(isEmpty())       //if head==null, return true
            head = tail =node;
        else {
            node.next= head;
            head =node;
        }
        size++;
    }
    // addLast
    public void addLast(int item){
        Node node=new Node(item);
        if(isEmpty())
            head = tail =node;
        else {
            tail.next=node;
            tail = node;
//            tail.next = head;
        }
        size++;
    }
    // deleteFirst
    public void deleteFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
//        Node currNode= head;
//        head =currNode.next;
        Node second = head.next;
        head.next=null;
        head=second;
        size--;
    }
    // deleteLast
    public void deleteLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(head==tail) {
            head = tail = null;
            return;
        }
        Node currNode= head;
        while(currNode.next.next != null)
            currNode=currNode.next;
        currNode.next=null;
        size--;
    }
    // contains
    // indexOf
    public void printList(){
        Node currNode= head;
        while(currNode != null){
            System.out.println(currNode.value);
            currNode=currNode.next;
        }
    }
    public boolean isCircular(){
        if(head == null || head.next == null)
            return false;
        Node slow = head;
        Node fast = head.next;
        while(slow.next != null){
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    private boolean isEmpty(){
        return head == null;
    }
}
