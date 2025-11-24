package com.subjects.student.studentController;


import com.subjects.student.subjectEntity.Subjects;
import com.subjects.student.subjectService.ServiceClass;
import com.subjects.student.subjectService.SubjectKafkaProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class TheController {

    @Autowired
    private SubjectKafkaProducer subjectKafkaProducer;
    @Autowired
    ServiceClass classService;

    @PostMapping("/score")
    @Operation(summary="Enter the scores for each subjects")
    @ApiResponses(value={@ApiResponse(responseCode = "201",description = "Created",content
            = {@Content(mediaType = "application/json", schema = @Schema(implementation = Subjects.class ))})
    ,@ApiResponse(responseCode = "400",description = "NOT SUCCESSFUL",content = @Content)})
    public ResponseEntity<Subjects>addingScore(@RequestBody Subjects score)
    {
        Subjects addSubjectScore = classService.addNewSubjectScore(score);
        subjectKafkaProducer.sendScores("subjects-sore",addSubjectScore);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build(addSubjectScore);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_JSON).build();
    }
    @GetMapping("/find/scores")
    @Operation(summary="Get all the scores subjects")
    @ApiResponses(value={@ApiResponse(responseCode = "200",description = "Get All Scores",content
            = {@Content(mediaType = "application/json", schema = @Schema(implementation = Subjects.class ))})
            ,@ApiResponse(responseCode = "400",description = "NO Data Found",content = @Content)})
    public ResponseEntity<List<Subjects>>getAllScores()
    {
        List<Subjects> allScores = classService.findAllScores();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build(allScores);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_JSON).build();

    }


}
