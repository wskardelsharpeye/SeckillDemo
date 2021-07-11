package com.example.controller;

import com.example.entity.Student;
import com.example.payload.CodeMsg;
import com.example.payload.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api2/v1/student/")
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"aaa"),
            new Student(2,"bbb"),
            new Student(3,"ccc")
    );

    @GetMapping(path = "{studentId}")
    public ResponseEntity getStudent(@PathVariable("studentId") Integer studentId) {
        return ResponseEntity.ok(STUDENTS.stream()
                .filter(stu -> studentId.equals(stu.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + "dosen't exists")));
    }

}
