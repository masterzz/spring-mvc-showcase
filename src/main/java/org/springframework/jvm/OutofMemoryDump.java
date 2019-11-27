package org.springframework.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OutofMemoryDump {
    /*jvm参数设置
        -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=I:\jvm
            * */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            i++;
        }
    }
}
