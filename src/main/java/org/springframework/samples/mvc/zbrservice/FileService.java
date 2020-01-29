package org.springframework.samples.mvc.zbrservice;

import datastructure.list.SinglyLinkedList;

public interface FileService {
    SinglyLinkedList<String> getPathByEnds(String path, String end);
}
