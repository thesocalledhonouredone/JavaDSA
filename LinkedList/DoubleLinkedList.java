class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoubleLinkedList {
    
    private Node head;
    private Node rear;
    private int length;

    DoubleLinkedList() {
        head = null;
        rear = null;
        length = 0;
    }

    DoubleLinkedList(int data) {
        head = new Node(data);
        rear = head;
        length = 1;
    }
    
    private boolean checkNULL() {
        return head == null && rear == null ? true : false;
    }
    
    public int length() { return length; }

    public void printForward() {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else {
            Node temp = head;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println("END OF LIST");
        }
    }

    public void printBackward() {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else {
            Node temp = rear;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.prev;
            }
            System.out.println("END OF LIST");
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(checkNULL()) {
            head = newNode;
            rear = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(checkNULL()) {
            head = newNode;
            rear = head;
        } else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            rear = newNode;
        }
        length++;
    }

    public void addMiddle(int data, int value) {
        if(checkNULL()) 
            System.out.println("EMPTY LIST");
        else {
            Node temp = head;
            while(temp != null) {
                if(temp.data == value) {
                    Node newNode = new Node(data);
                    Node holder = temp.next;

                    temp.next = newNode;
                    holder.prev = newNode;

                    newNode.prev = temp;
                    newNode.next = holder;

                    length++;
                    return;
                }
                temp = temp.next;
            }
            System.out.println("VALUE NOT FOUND IN LIST");
        }
    }

    public void deleteFirst() {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else if(head.next == null) {
            head = null;
            rear = null;
            length = 0;
        } else {
            head = head.next;
            head.prev = null;
            length--;
        }
    }

    public void deleteLast() {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else if(rear.prev == null) {
            rear = null;
            head = null;
            length = 0;
        } else {
            rear = rear.prev;
            rear.next = null;
            length--;
        }
    }

    public void deleteMiddle(int value) {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else if((head.next == null && head.data == value) || (rear.prev == null && rear.data == value)) {
            head = null;
            rear = null;
            length = 0;
        } else {
            Node temp = head;
            while(temp != null) {
                if(temp.data == value) {
                    Node holder = temp.prev;
                    holder.next = temp.next;
                    temp.next.prev = holder;
                    length--;
                    return;
                }
                temp = temp.next;
            }
            System.out.println("VALUE NOT FOUND IN LIST");
        }
    }

    public int indexOf(int target) {
        if(checkNULL()) {
            System.out.println("EMPTY LIST");
            return -1;
        } else {
            Node temp = head;
            int index = 0;
            while(temp != null) {
                if(temp.data == target)
                    return index;
                temp = temp.next;
                index++;
            }
            return -1;
        }
    }

    public int get(int index) {
        if(checkNULL()) {
            System.out.println("EMPTY LIST");
            return Integer.MIN_VALUE;
        } else {
            if(index >= length)
                return Integer.MIN_VALUE;

            Node temp = head;
            while(index > 0) {
                temp = temp.next;
                index--;
            }
            return index;
        }
    }

    public void join(DoubleLinkedList list) {
        if(checkNULL() || list.checkNULL()) {
            System.out.println("EMPTY LIST");
        } else {
            Node temp = head;
            while(temp.next != null) 
                temp = temp.next;
            temp.next = list.head;
            list.head.prev = temp;
            length += list.length;
        }
    }

    public void reverseList() {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else {
            Node current = head;
            Node temp = null;
            while(current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;

                current = current.prev;
            }

            if(temp != null) {
                head = temp.prev;
            }

            temp = head;
            while(temp != null) {
                rear = temp;
                temp = temp.next;
            }
        }
    }

    public int min() {
        if(checkNULL()) {
            System.out.println("EMPTY LIST");
            return Integer.MIN_VALUE;
        } else {
            int min = Integer.MAX_VALUE;
            Node temp = head;
            while(temp != null) {
                if(temp.data < min)
                    min = temp.data;
                temp = temp.next;
            }
            return min;
        }
    }

    public int max() {
        if(checkNULL()) {
            System.out.println("EMPTY LIST");
            return Integer.MIN_VALUE;
        } else {
            Node temp = head;
            int max = 0;
            while(temp != null) {
                if(temp.data > max)
                    max = temp.data;
                temp = temp.next;
            }
            return max;
        }
    }

    public void clear() {
        if(checkNULL())
            System.out.println("LIST IS ALREADY EMPTY");
        else {
            head = null;
            rear = null;
            length = 0;
        }
    }
}