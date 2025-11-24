package com.student.data.analyticController;


import com.student.data.analyticalEntity.ScoreEntity;
import com.student.data.analyticalService.ScoreService;
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
@RequestMapping("/api/calculate")
public class AnalyzeScore {

    @Autowired
    private ScoreService scoreService;

    @Operation(summary = "Get the mean score")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Mean Scores", content
            = {@Content(mediaType = "application/json", schema = @Schema(implementation = ScoreEntity.class))})
            , @ApiResponse(responseCode = "400", description = "NO Data Found", content = @Content)})
    @GetMapping("/mean/{name}")
    public ResponseEntity<Double> getMeanScore(@PathVariable("name") String name) {
        Double result = scoreService.findMean(name);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build(result);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        header.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok().headers(header).build();
    }

    @Operation(summary = "Get the model score")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Mode Scores", content
            = {@Content(mediaType = "application/json", schema = @Schema(implementation = ScoreEntity.class))})
            , @ApiResponse(responseCode = "400", description = "NO Data Found", content = @Content)})
    @GetMapping("/model/{name}")
    public ResponseEntity<Double> getModeScore(@PathVariable("name") String name) {
        Double result = scoreService.findModel(name);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build(result);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        header.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok().headers(header).build();
    }

    @Operation(summary = "Get the median score")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Median Scores", content
            = {@Content(mediaType = "application/json", schema = @Schema(implementation = ScoreEntity.class))})
            , @ApiResponse(responseCode = "400", description = "NO Data Found", content = @Content)})
    @GetMapping("/median/{name}")
    public ResponseEntity<Double> getMedianScore(@PathVariable("name") String name) {
        Double result = scoreService.findMedian(name);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build(result);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        header.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok().headers(header).build();
    }


}
