package com.uptc.frw.controllers;

import com.uptc.frw.models.Agency;
import com.uptc.frw.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencies")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public ResponseEntity<List<Agency>> getAllAgencies() {
        return ResponseEntity.ok(agencyService.getAllAgencies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agency> getAgencyById(@PathVariable Long id) {
        return ResponseEntity.ok(agencyService.getAgencyById(id));
    }

    @PostMapping
    public ResponseEntity<Agency> createAgency(@RequestBody Agency agency) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agencyService.createAgency(agency));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agency> updateAgency(@PathVariable Long id, @RequestBody Agency agency) {
        return ResponseEntity.ok(agencyService.updateAgency(id, agency));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
        agencyService.deleteAgency(id);
        return ResponseEntity.noContent().build();
    }
}