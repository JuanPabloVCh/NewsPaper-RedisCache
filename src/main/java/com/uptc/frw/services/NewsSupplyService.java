package com.uptc.frw.services;

import com.uptc.frw.models.NewsSupply;
import com.uptc.frw.models.key.NewsSupplyId;
import com.uptc.frw.repositories.NewsSupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsSupplyService {

    @Autowired
    private NewsSupplyRepository newsSupplyRepository;

    public NewsSupplyService(NewsSupplyRepository newsSupplyRepository) {
        this.newsSupplyRepository = newsSupplyRepository;
    }

    public List<NewsSupply> getAllNewsSupplies() {
        return newsSupplyRepository.findAll();
    }

    public NewsSupply getNewsSupply(Long reportId, Long agencyId) {
        NewsSupplyId id = new NewsSupplyId(reportId, agencyId);
        return newsSupplyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NewsSupply not found"));
    }

    public NewsSupply createNewsSupply(NewsSupply newsSupply) {
        return newsSupplyRepository.save(newsSupply);
    }

    public void deleteNewsSupply(Long reportId, Long agencyId) {
        NewsSupplyId id = new NewsSupplyId(reportId, agencyId);
        newsSupplyRepository.deleteById(id);
    }
}
