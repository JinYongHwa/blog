package kr.ac.mjc.itc.blog.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/thymeleaf/example")
    public ModelAndView thymeleafExample(){
        ModelAndView mav=new ModelAndView();
        Person examplePerson=new Person();
        examplePerson.setId(1l);
        examplePerson.setName("홍길동");
        examplePerson.setAge(11);
        examplePerson.setHobbies(List.of("운동","독서"));
        mav.addObject("person", examplePerson);
        mav.addObject("today", LocalDate.now());
        mav.setViewName("example");
        return mav;
    }


    @Setter
    @Getter
    class Person{
        private long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}
