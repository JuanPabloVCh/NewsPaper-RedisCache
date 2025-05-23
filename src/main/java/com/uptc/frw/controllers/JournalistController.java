package com.uptc.frw.controllers;

import com.uptc.frw.models.Journalist;
import com.uptc.frw.services.JournalistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journalist")
public class JournalistController {

    @Autowired
    private JournalistService journalistService;

    public JournalistController(JournalistService journalistService) {
        this.journalistService = journalistService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Journalist>> getAllJournalists() {
        return ResponseEntity.ok(journalistService.getAllJournalists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journalist> getJournalistById(@PathVariable Long id) {
        return ResponseEntity.ok(journalistService.getJournalistById(id));
    }

    @PostMapping
    public ResponseEntity<Journalist> createJournalist(@RequestBody Journalist journalist) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(journalistService.createJournalist(journalist));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Journalist> updateJournalist(@PathVariable Long id, @RequestBody Journalist journalist) {
        return ResponseEntity.ok(journalistService.updateJournalist(id, journalist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJournalist(@PathVariable Long id) {
        journalistService.deleteJournalist(id);
        return ResponseEntity.noContent().build();
    }
}
