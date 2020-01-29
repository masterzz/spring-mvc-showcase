package datastructure.list;

public class SinglyLinkedList<T> implements LList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public SinglyLinkedList() {
        head = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return null == head;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T get(int i) {
        Node<T> result = head;
        if(i > length)
            throw new RuntimeException("获取的值大于链表长度");
        for (int j = 0; j < i; j++) {
            result = result.getNext();
        }
        return result.getData();
    }

    @Override
    public void append(T x) {
        length++;
        if (this.isEmpty()) {
            this.head = new Node<T>(x, null);
            this.tail = this.head;
        } else {
//            把新节点加在尾部
            Node<T> newTail = new Node<T>(x,null);
            this.tail.setNext(newTail);
            this.tail = newTail;
        }
    }



    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println(singlyLinkedList.isEmpty());
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);

        System.out.println(singlyLinkedList.get(0));
        System.out.println(singlyLinkedList.get(1));
        System.out.println(singlyLinkedList.get(2));
        System.out.println(singlyLinkedList.isEmpty());
    }
}
