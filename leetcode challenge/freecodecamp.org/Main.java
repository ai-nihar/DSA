import java.util.*;

public class Main {
    public static void main(String[] args) {
        Section7.BST bst = new Section7.BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(7);
        bst.insert(1);
        bst.insert(6);

        System.out.println(bst.s7p2(5));
    }
}

class Section1 { // Arrays
    // problem 1: Given an array of integers, find the second largest number in it — without sorting the array.

    public int s1p1 (int[] nums) {
        int max = nums[0], ans = nums[1];

        if (max<ans) {
            max = ans;
            ans = nums[0];
        }

        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (num>=max) {
                ans = max;
                max = num;
            } else if (num>ans) ans = num;
        }

        return ans;
    }

    // Problem 2: You're given an array of ticket prices for 7 days. You can buy one ticket on one day and sell it on a later day. Find the maximum profit possible (or 0 if no profit is possible).

    public int s1p2 (int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = s1p2Helper(prices, i)-prices[i];
            if (temp>profit) profit=temp;
        }
        return profit;
    }

    private int s1p2Helper (int[] nums, int start) {
        int max = nums[start];
        for (int i = start; i < nums.length; i++) if (nums[i]>max) max=nums[i];
        return max;
    }
}

class Section2 { //LinkedList
    // Problem 3: Implement a singly linked list from scratch (Node class + insert at end + print all values).
    static class SLL {
        class Node {
            int data;
            Node next;

            Node (int data) {
                this.data = data;
                this.next = null;
            }
        }
        Node head;

        SLL () {
            head = null;
        }

        public void insertAtStart (int data) {
            Node n = new Node(data);
            n.next = head;
            head = n;
        }

        public void insertAtLast (int data) {
            if (head==null) head = new Node(data);
            else {
                Node temp = head;
                while (temp.next!=null) temp=temp.next;
                temp.next = new Node(data);
            }
        }

        public void printSLL () {
            Node temp = head;

            System.out.print("head -> ");
            while (temp!=null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // Problem 2: Given a singly linked list, reverse it in place (don't create a new list).
        public void s2p2() {
            if (head==null) return;

            Node temp = head.next, next=null;

            if (temp!=null) {
                next = temp.next;
            }

            head.next = null;

            while (temp!=null) {
                temp.next = head;
                head = temp;
                temp = next;
                if (next!=null) next = next.next;
            }
        }

        // Problem 3: Given a singly linked list, find the middle node in a single pass (you may only traverse the list once).
        public Node s2p3 () {
            Node tail = head, mid = head;
            int count = 1;

            while (tail.next!=null) {
                count++;
                if (count%2==0) {
                    mid=mid.next;
                }
                tail=tail.next;
            }
            return mid;
        }
    }
}

class Section3 { // Stack
    // Problem 1: Implement a stack using an array (push, pop, peek, isEmpty).
    static class Stack {
        int[] stack;
        int top, size;

        Stack(int capacity) {
            stack = new int[capacity];
            top = 0;
            size = capacity;
        }

        public void push(int data) {
            if (top==size-1) System.out.println("Error: Stack Overflow");
            else stack[top++] = data;
        }

        public int pop() {
            if (top==0) {
                System.out.println("Error: Stack UnderFlow");
                return 0;
            }
            else return stack[--top];
        }

        public int peek () {
            if (top==0) {
                System.out.println("Error: Stack UnderFlow");
                return 0;
            }
            else return stack[top-1];
        }

        public boolean isEmpty () {
            return top==0 && top<size;
        }

        public void printStack() {
            System.out.print("Stack: ");

            for (int i = 0; i < top; i++) {
                System.out.print(stack[i] + " ");
            }

            System.out.println();
        }
    }

    // Problem 2: Given a string containing only (, ), {, }, [, ], determine if the brackets are balanced/valid.
    public boolean s3p2(String s) {
        Stack stack = new Stack(10);

        for (char c:s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if ((c==')' && stack.peek()=='(') || (c==']' && stack.peek()=='[') || (c=='}' && stack.peek()=='{')) stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }

    // Problem 3: Implement "undo" behavior: given a sequence of typed characters and occasional "undo" commands, output the final string.
    public String s3p3 (String s) {
        String[] chars = s.split(", ");
        Stack stack = new Stack(10);

        for (String i:chars) {
            if (i.equals("U") && !stack.isEmpty()) stack.pop();
            else if (i.equals("U")) continue;
            else stack.push((int)i.charAt(0));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char)stack.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}

class Section4 { // Queue
    // Problem 1: Implement a queue using an array (enqueue, dequeue, front, isEmpty).

    static class Queue {
        int[] queue;
        int size, front, rear;

        Queue (int capacity) {
            size = capacity;
            queue = new int[size];
            front=0;
            rear=-1;
        }

        public void enqueue (int data) {
            if (rear==size-1) {
                System.out.println("Queue OverFlow");
                return;
            }
            queue[++rear] = data;
        }

        public int dequeue () {
            if (front==rear+1) {
                System.out.println("Queue UnderFlow");
                return 0;
            }

            return queue[front++];
        }

        public int getFront() {
            if (front==rear+1) {
                System.out.println("Queue is empty");
                return 0;
            }

            return queue[front];
        }

        public boolean isEmpty () {
            return front==rear+1;
        }
    }

    // Problem 4: Simulate the printer queue example from the video — given a list of print jobs arriving in order, process and output them in the order they'll actually print.
    public int[] s4p2(int[] sequence) {
        Queue queue = new Queue(sequence.length);

        for(int i:sequence) queue.enqueue(i);

        int[] ans = new int[sequence.length];

        int i = 0;

        while (!queue.isEmpty()) ans[i++]=queue.dequeue();

        return ans;
    }
}

class Section5 { // Priority Queue / Heap
    // Problem 1: Given a list of patients with priority levels (like the ER example), process them in priority order rather than arrival order.
    static class Heap { // Max heap
        int[] heap;
        int rear, root;

        Heap (int capacity) {
            heap = new int[capacity];
            rear = 0;
            root = -1;
        }

        public void insert (int data) {
            if (rear==heap.length) {
                System.out.println("HeapOverFlow");
                return;
            }
            heap[rear++] = data;
            if (root==-1) root = 0;
            else swapInsert(rear-1);
        }

        private void swapInsert (int index) {
            if (heap[index]>heap[(index-1)/2]) {
                int temp = heap[index];
                heap[index] = heap[(index-1)/2];
                heap[(index-1)/2] = temp;
                swapInsert((index-1)/2);
            }
        }

        public int discard () {
            if (root==-1) {
                System.out.println("HeapUnderFlow");
                return 0;
            }
            int r = heap[root];

            if (rear==root+1) {
                root = -1;
                rear--;
            }
            else {
                heap[root] = heap[--rear];
                swapDiscard(root);
            }


            return r;
        }

        private void swapDiscard (int index) {
            int left = (index*2)+1, right = (index*2)+2;

            if (left>=rear) return;

            if ((right>=rear || heap[left]>heap[right]) && heap[index]<heap[left]) {
                int temp = heap[index];
                heap[index] = heap[left];
                heap[left] = temp;
                swapDiscard(left);
            } else if (heap[right]>heap[left] && heap[index]<heap[right]) {
                int temp = heap[index];
                heap[index] = heap[right];
                heap[right] = temp;
                swapDiscard(right);
            }
        }
    }

    static class PriorityQueue {
        HashMap<Integer, LinkedList<String>> map;
        Heap heap;

        PriorityQueue (int capacity) {
            heap = new Heap(capacity);
            map = new HashMap<>();
        }

        public void insert (int priorityValue, String name) {
            map.computeIfAbsent(priorityValue, k -> new LinkedList<>()).addLast(name);
            heap.insert(priorityValue);
        }

        public String discard () {
            int priorityValue = heap.discard();
            LinkedList<String> list = map.get(priorityValue);
            if (list.size() == 1) {
                String ans = list.removeFirst();
                map.remove(priorityValue);
                return ans;
            }
            return list.removeFirst();
        }
    }

    // Problem 2: Given an array of numbers, find the k largest numbers using a heap-based approach (not full sorting).

    public int[] s5p2(int[] nums, int n) {
        int[] ans = new int[n];

        Heap heap = new Heap(100);

        for (int num:nums) heap.insert(num);

        while (n>0) {
            ans[ans.length-n] = heap.discard();
            n--;
        }

        return ans;
    }
}

class Section6 { // Hash Table / Set
    // Problem 1: Given an array of integers, find if there are any duplicate values — using a hash-based approach (not nested loops).
    public boolean s6p1 (int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num:nums) set.add(num);

        return nums.length!=set.size();
    }

    // Problem 2: Given two arrays, find all elements that are common to both, using a set-based approach.
    public int[] s6p2 (int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num: nums1) set1.add(num);
        for (int num: nums2) set2.add(num);

        set1.removeIf(integer -> !set2.contains(integer));

//        Iterator<Integer> iterator = set1.iterator();
//        while (iterator.hasNext()) if (!set2.contains(iterator.next())) iterator.remove();

        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    // Problem 3: Given a list of email addresses with possible duplicates, return the list with duplicates removed, preserving first-seen order.
    public String[] s6p3 (String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email:emails) {
            if (!set.contains(email)) emails[set.size()] = email;
            set.add(email);
        }

        return Arrays.copyOf(emails, set.size());
    }
}

class Section7 { // Tree / Binary Search Tree
    // Problem 1: Implement a binary search tree with an insert method.
    static class BST {
        class Node {
            int data;
            Node left, right;

            Node (int data) {
                this.data = data;
                left = null;
                right = null;
            }
        }

        Node root;

        BST () {
            root = null;
        }

        public void insert (int data) {
            if (root==null) root = new Node(data);
            else compareInsert(data, root);
        }

        private void compareInsert (int data, Node n) {
            if (data<n.data) {
                if (n.left!=null) compareInsert(data, n.left);
                else n.left = new Node(data);
            } else {
                if (n.right!=null) compareInsert(data, n.right);
                else n.right = new Node(data);
            }
        }


//        sideways print - reverse inorder
        public void printBST (Node node, int indent) {
            if (node.right!=null) printBST(node.right, indent+1);
            for (int i = 0; i < indent; i++) System.out.print("   ");
            System.out.println(node.data);
            if (node.left!=null) printBST(node.left, indent+1);
        }

        // Problem 2: Given a BST, write a search method that returns true/false for whether a value exists.
        public boolean s7p2(int value) {
            Node temp = root;

            while (temp!=null) {
                if (value>temp.data) temp = temp.right;
                else if (value<temp.data) temp = temp.left;
                else return true;
            }

            return false;
        }

        // Problem 3: Given a BST, print all values in sorted order (in-order traversal) — figure out why this specific traversal order gives you sorted output.
        public void s7p3 (Node node) {
            if (node.left!=null) s7p3(node.left);
            System.out.println(node.data);
            if (node.right!=null) s7p3(node.right);
        }
    }
}


