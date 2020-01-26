package org.springframework.samples.mvc.zbrcontroller;

import datastructure.list.SinglyLinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.mvc.zbrservice.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zbr")
public class QueryController {
    @Autowired
    FileService fileService;

    @GetMapping("/queryPath")
    public List<String> uriTemplate(RedirectAttributes redirectAttrs) {
//        redirectAttrs.addAttribute("account", "a123");  // Used as URI template variable
//        redirectAttrs.addAttribute("date", new LocalDate(2011, 12, 31));  // Appended as a query parameter
        SinglyLinkedList<String> link = fileService.getPathByEnds("F:\\lesson", ".mp4");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < link.length(); i++) {
            list.add(link.get(i));
        }
        System.out.println("sssss");
        return list;
    }
}
