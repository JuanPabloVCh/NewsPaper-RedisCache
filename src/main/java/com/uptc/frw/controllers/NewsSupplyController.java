package com.uptc.frw.controllers;

import com.uptc.frw.models.NewsSupply;
import com.uptc.frw.services.NewsSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news-supplies")
public class NewsSupplyController {

    @Autowired
    private NewsSupplyService newsSupplyService;

    public NewsSupplyController(NewsSupplyService newsSupplyService) {
        this.newsSupplyService = newsSupplyService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<NewsSupply>> getAllNewsSupplies() {
        return ResponseEntity.ok(newsSupplyService.getAllNewsSupplies());
    }

    @GetMapping("/{reportId}/{agencyId}")
    public ResponseEntity<NewsSupply> getNewsSupply(
            @PathVariable Long reportId,
            @PathVariable Long agencyId) {
        return ResponseEntity.ok(newsSupplyService.getNewsSupply(reportId, agencyId));
    }

    @PostMapping
    public ResponseEntity<NewsSupply> createNewsSupply(@RequestBody NewsSupply newsSupply) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newsSupplyService.createNewsSupply(newsSupply));
    }

    @DeleteMapping("/{reportId}/{agencyId}")
    public ResponseEntity<Void> deleteNewsSupply(
            @PathVariable Long reportId,
            @PathVariable Long agencyId) {
        newsSupplyService.deleteNewsSupply(reportId, agencyId);
        return ResponseEntity.noContent().build();
    }
}
