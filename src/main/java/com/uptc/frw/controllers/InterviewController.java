package com.uptc.frw.controllers;

import com.uptc.frw.models.Interview;
import com.uptc.frw.services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews() {
        return ResponseEntity.ok(interviewService.getAllInterviews());
    }

    @GetMapping("/{journalistId}/{reportId}/{involvedId}")
    public ResponseEntity<Interview> getInterview(
            @PathVariable Long journalistId,
            @PathVariable Long reportId,
            @PathVariable Long involvedId) {
        return ResponseEntity.ok(interviewService.getInterview(journalistId, reportId, involvedId));
    }

    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(interviewService.createInterview(interview));
    }

    @DeleteMapping("/{journalistId}/{reportId}/{involvedId}")
    public ResponseEntity<Void> deleteInterview(
            @PathVariable Long journalistId,
            @PathVariable Long reportId,
            @PathVariable Long involvedId) {
        interviewService.deleteInterview(journalistId, reportId, involvedId);
        return ResponseEntity.noContent().build();
    }
}
