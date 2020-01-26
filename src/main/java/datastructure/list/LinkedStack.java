package datastructure.list;

public class LinkedStack<T> {
    Node<T> top;

    public LinkedStack() {
        top = null;
    }

    public void push(T x) {
        if (null == top)
            top = new Node<>(x, null);
        else {
            Node<T> newNode = new Node<>(x, top);
            top = newNode;
        }
    }

    public T pop() {
        if (top == null) return null;
        T result = top.getData();
        top = top.getNext();
        return result;
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);

        System.out.println(linkedStack.pop());
        linkedStack.push(3);
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
    }
}
