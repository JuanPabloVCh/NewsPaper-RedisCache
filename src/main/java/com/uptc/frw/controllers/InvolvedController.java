package com.uptc.frw.controllers;

import com.uptc.frw.models.Involved;
import com.uptc.frw.services.InvolvedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/involved")
public class InvolvedController {

    @Autowired
    private InvolvedService involvedService;

    public InvolvedController(InvolvedService involvedService) {
        this.involvedService = involvedService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Involved>> getAllInvolveds() {
        return ResponseEntity.ok(involvedService.getAllInvolved());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Involved> getInvolvedById(@PathVariable Long id) {
        return ResponseEntity.ok(involvedService.getInvolvedById(id));
    }

    @PostMapping
    public ResponseEntity<Involved> createInvolved(@RequestBody Involved involved) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(involvedService.createInvolved(involved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Involved> updateInvolved(@PathVariable Long id, @RequestBody Involved involved) {
        return ResponseEntity.ok(involvedService.updateInvolved(id, involved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvolved(@PathVariable Long id) {
        involvedService.deleteInvolved(id);
        return ResponseEntity.noContent().build();
    }
}
