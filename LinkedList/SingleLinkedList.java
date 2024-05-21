class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class SingleLinkedList {
    
    private Node head;
    private int length;

    SingleLinkedList() {
        head = null;
        length = 0;
    }

    SingleLinkedList(int data) {
        head = new Node(data);
        length = 1;
    }

    private boolean checkNULL() {
        return (head == null) ? true : false;
    }

    public int length() { return length; }

    public void printList() {
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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(checkNULL()) 
            head = newNode;
        else {
            Node temp = head;
            temp.next = newNode;
            head = newNode;
        }
        length++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(checkNULL())
            head = newNode;
        else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        length++;
    }

    public void addMiddle(int data, int value) {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else {
            Node temp = head;
            Node shadow = null;
            while(temp != null) {
                shadow = temp;
                temp = temp.next;
                if(shadow.data == value) {
                    Node newNode = new Node(data);
                    shadow.next = newNode;
                    newNode.next = temp;
                    length++;
                    return;
                }
            }
            System.out.println("VALUE CANNOT BE FOUND IN LIST");
        }
    }

    public void deleteFirst() {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else {
                head = head.next;
                length--;
        }
    }

    public void deleteLast() {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else {
            Node temp = head;
            Node shadow = null;
            while(temp.next != null) {
                shadow = temp;
                temp = temp.next;
            }
            shadow.next = null;
            length--;
        }
    }

    public void deleteMiddle(int value) {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else {
            Node temp = head;
            Node shadow = null;
            while(temp != null) {
                shadow = temp;
                temp = temp.next;
                if(shadow.data == value) {
                    shadow.next = temp.next;
                    length--;
                    return;
                }
            }
            System.out.println("VALUE CANNOT BE FOUND IN LIST");
        }
    }

    void addArray(int[] arr) {
        if(checkNULL()) {
            head = new Node(arr[0]);
            for(int i=1;i<arr.length;i++) 
                addLast(arr[i]);
        } else {
            for(int i=0;i<arr.length;i++) {
                addLast(arr[i]);
            }
        }
        length += arr.length;
    }

    public int indexOf(int target) {
        if(checkNULL()) {
            System.out.println("EMPTY LIST");
            return Integer.MIN_VALUE;
        } else {
            Node temp = head;
            int index = 0;
            while(temp != null)  {
                if(temp.data == target) 
                    return index;
                temp = temp.next;
                index++;
            }
            return Integer.MIN_VALUE;
        }
    } 
    
    public int get(int index) {
        if(checkNULL()) {
            System.out.println("EMPTY LIST");
            return -1;
        } else {
            if(index >= length) 
                return -1;
            
            Node temp = head;
            while(index > 0) {
                temp = temp.next;
                index--;
            }
            return temp.data;
        }
    }

    public void join(SingleLinkedList list) {
        if(checkNULL() || list.checkNULL())
            System.out.println("LIST IS EMPTY");
        else {
            if(head.next == null) {
                head.next = list.head;
                length += list.length;
                return;
            }

            Node temp = head;
            while(temp.next != null) 
                temp = temp.next;
            temp.next = list.head;
        }
    }

    public void reverseList() {
        if(checkNULL())
            System.out.println("EMPTY LIST");
        else if(head.next == null)
            return;
        else {
            Node prev = null;
            Node curr = head;
            Node next = null;

            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            } 
            head = prev;
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
            int max = 0;
            Node temp = head;
            while(temp != null) {
                if(temp.data > max)
                    max = temp.data;
                temp = temp.next;
            }
            return max;
        }
    }

    public void clearList() {
        if(checkNULL())
            System.out.println("LIST IS ALREDY EMPTY");
        else 
            head = null;
    }
}