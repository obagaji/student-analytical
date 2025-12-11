package com.student_info.studentController;

import com.student_info.studentEntiry.StudentEntity;
import com.student_info.studentService.ServiceImpl;
import com.student_info.studentService.StudentNameId;
import com.student_info.studentService.StudentSubjectImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/student")
public class StudentController {


    @Autowired
    private ServiceImpl impl;
    @Autowired
    private StudentSubjectImp subjectImp;

    @Operation(summary = "Get Student with the id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Student Found",
            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = StudentEntity.class))}),
            @ApiResponse(responseCode = "400",description = " Student Not Found",content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity>getStudentById(@PathVariable("id")Long id)
    {
        StudentEntity student = impl.getStudentWithId(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_JSON).body(student);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentNameId>getStudentForScore(@PathVariable("id")Long id)
    {
        StudentNameId student = subjectImp.getStudentName(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_JSON).body(student);
    }
}
