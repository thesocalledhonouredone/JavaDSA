class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {

    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        size = 0;
    }

    public Stack(int data) {
        this.top = new Node(data);
        size = 1;
    }

    public boolean isEmpty() {
        return top == null ? true : false;
    }

    public int size() { return size; }

    public void push(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) 
            top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("EMPTY STACK");
            return -1;
        } else {
            int temp = top.data;
            top = top.next;
            size--;
            return temp;
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("EMPTY LIST");
            return -1;
        } else {
            return top.data;
        }
    }   
    
    public void showStack() {
        if(isEmpty())
            System.out.println("EMPTY LIST");
        else {
            Node temp = top;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println("END OF STACK");
        }
    }

    public boolean contains(int value) {
        if(isEmpty()) {
            System.out.println("EMPTY LIST");
            return false;
        } else {
            Node temp = top;
            while(temp != null) {
                if(temp.data == value)
                    return true;
                temp = temp.next;
            }
            return false;
        }
    }

    public void pushArray(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            push(arr[i]);
        }
    }

    public void clear() {
        top = null;
        size = 0;
    }
}