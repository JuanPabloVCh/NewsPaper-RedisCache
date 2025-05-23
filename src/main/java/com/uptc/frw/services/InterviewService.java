package com.uptc.frw.services;

import com.uptc.frw.models.Interview;
import com.uptc.frw.models.key.InterviewId;
import com.uptc.frw.repositories.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }
    @Cacheable("interview")
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }
    @Cacheable(value = "interview", key = "#id")
    public Interview getInterview(Long journalistId, Long reportId, Long involvedId) {
        InterviewId id = new InterviewId(journalistId, reportId, involvedId);
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public void deleteInterview(Long journalistId, Long reportId, Long involvedId) {
        InterviewId id = new InterviewId(journalistId, reportId, involvedId);
        interviewRepository.deleteById(id);
    }
}