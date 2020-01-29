package datastructure.list;

public interface LList<T> {
    boolean isEmpty();// 判断线性报是否为空

    int length();// 返回线性表长度

    T get(int i);// 返回第i个元素

    void append(T x);// 在线性表最后插入x元素
}
