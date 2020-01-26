package org.springframework.samples.mvc.zbrcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.mvc.zbrservice.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/zbr")
public class QueryController {
    @Autowired
    FileService fileService;

    @GetMapping("/queryPath")
    public String uriTemplate(RedirectAttributes redirectAttrs) {
//        redirectAttrs.addAttribute("account", "a123");  // Used as URI template variable
//        redirectAttrs.addAttribute("date", new LocalDate(2011, 12, 31));  // Appended as a query parameter
        fileService.getPathByEnds("I:\\java编程", ".pbb");
        System.out.println("sssss");
        return "aaaa";
    }
}
