package com.biet_sm.StudentManagementSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("students", service.getAll());
        model.addAttribute("student", new Student());
        return "index";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Student student){
        service.save(student);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        Student student = service.getByID(id);
        model.addAttribute("student", student);
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Student student){
        service.save(student);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/";
    }
}
