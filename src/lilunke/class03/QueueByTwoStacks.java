package lilunke.class03;

import java.util.LinkedList;
import java.util.Stack;

public class QueueByTwoStacks {
//    private Stack<Integer> in;
//    private Stack<Integer> out;
//    public void Solution() {
//        // Write your removeCho2 here.
//        in = new Stack<Integer>();
//        out = new Stack<Integer>();
//    }
//
//    private void move() {
//        if (out.empty()) {
//            while(!in.empty()) {
//                out.push(in.pop());
//            }
//        }
//    }
//
//    public Integer poll() {
//        move();
//        if (!out.empty()) {
//            return out.pop();
//        } else {
//            return null;
//        }
//    }
//
//    public void offer(int element) {
//        in.push(element);
//    }
//
//    public Integer peek() {
//        move();
//        if(!out.empty()) {
//            return out.peek();
//        } else {
//            return null;
//        }
//    }
//
//    public int size() {
//        return in.size() + out.size();
//    }
//
//    public boolean isEmpty() {
//        return in.empty() && out.empty();
//    }
//    private LinkedList<Integer> in;
//    private LinkedList<Integer> out;
//    public void Solution() {
//        // Write your removeCho2 here.
//        in = new LinkedList<Integer>();
//        out = new LinkedList<Integer>();
//    }
//    private void move() {
//        if (out.isEmpty()) {
//            while (!in.isEmpty()) {
//                out.offerFirst(in.pollFirst());
//            }
//        }
//    }
//    public Integer poll() {
//        move();
//        return out.isEmpty() ? null : out.pollFirst();
//    }
//
//    public void offer(int element) {
//        in.offerFirst(element);
//    }
//
//    public Integer peek() {
//        move();
//        return out.isEmpty() ? null : out.peekFirst();
//    }
//
//    public int size() {
//        return in.size() + out.size();
//    }
//
//    public boolean isEmpty() {
//        return in.isEmpty() && out.isEmpty();
//    }
    private Stack<Integer> in;
    private Stack<Integer> out;
    public void Solution() {
        // Write your removeCho2 here.
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }
    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
    public Integer poll() {
        move();
        return out.isEmpty() ? null : out.pop();
    }

    public void offer(int element) {
        in.push(element);
    }

    public Integer peek() {
        move();
        return out.isEmpty() ? null : out.peek();
    }

    public int size() {
        return in.size() + in.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main (String[] args) {
        QueueByTwoStacks here = new QueueByTwoStacks();
        here.Solution();
        //here.offer(5);
        System.out.println(here.poll());
    }
}
