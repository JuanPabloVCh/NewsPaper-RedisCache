package com.uptc.frw.services;

import com.uptc.frw.models.Involved;
import com.uptc.frw.repositories.InvolvedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvolvedService {

    @Autowired
    private InvolvedRepository involvedRepository;

    public InvolvedService(InvolvedRepository involvedRepository) {
        this.involvedRepository = involvedRepository;
    }
    @Cacheable(value = "involved")
    public List<Involved> getAllInvolved() {
        return involvedRepository.findAll();
    }

    @Cacheable(value = "involved", key = "#id")
    public Involved getInvolvedById(Long id) {
        return involvedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Involved not found"));
    }

    public Involved createInvolved(Involved involved) {
        return involvedRepository.save(involved);
    }

    public Involved updateInvolved(Long id, Involved involvedDetails) {
        Involved involved = getInvolvedById(id);
        involved.setName(involvedDetails.getName());
        involved.setBirthDate(involvedDetails.getBirthDate());
        return involvedRepository.save(involved);
    }

    public void deleteInvolved(Long id) {
        involvedRepository.deleteById(id);
    }
}
