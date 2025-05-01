package com.csrf.auth.controller;
import com.csrf.auth.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Ishwarya", "ECE"),
                    new Student(2, "Mila", "ECE")
            )
    );

    @GetMapping("/student")
    public List<Student> getStudents()
    {
        return students;
    }

    @PostMapping("/addStudent")
    public void student(@RequestBody  Student student)
    {
        students.add(student);
    }
    @GetMapping("csrf_token")
    public CsrfToken csrfToken(HttpServletRequest req)
    {
        return (CsrfToken) req.getAttribute("_csrf");
    }

}

