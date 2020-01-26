package org.springframework.samples.mvc.zbrservice;

import datastructure.list.LinkedStack;
import datastructure.list.SinglyLinkedList;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public SinglyLinkedList<String> getPathByEnds(String path, String end) {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        SinglyLinkedList<String> stringSinglyLinkedList = new SinglyLinkedList<String>();
        String tempPath = null;
        linkedStack.push(path);
        while ((tempPath = linkedStack.pop()) != null) {
            File file = new File(tempPath);
            if (!file.exists()) {
                System.out.println("文件不存在");
            }
            for (File file1 : file.listFiles()) {
                if (file1.isDirectory()) linkedStack.push(file1.getPath());
                if (file1.getName().endsWith(end)) {
                    stringSinglyLinkedList.append(file1.getPath());
//                    file1.delete();
                }
            }
        }

        return stringSinglyLinkedList;
    }

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        SinglyLinkedList<String> stringSinglyLinkedList = fileService.getPathByEnds("F:\\lesson", ".mp4");
        for (int i = 0; i < stringSinglyLinkedList.length(); i++) {
            System.out.println(stringSinglyLinkedList.get(i));
        }
    }
}
