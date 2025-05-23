package com.uptc.frw.services;

import com.uptc.frw.models.Journalist;
import com.uptc.frw.repositories.JournalistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalistService {

    @Autowired
    private JournalistRepository journalistRepository;

    public JournalistService(JournalistRepository journalistRepository) {
        this.journalistRepository = journalistRepository;
    }
    @Cacheable(value = "journalists")
    public List<Journalist> getAllJournalists() {
        List<Journalist> lista = journalistRepository.findAll();

        System.out.println(lista.size());
        return journalistRepository.findAll();


    }
    @Cacheable(value = "journalists", key = "#id")
    public Journalist getJournalistById(Long id) {
        return journalistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journalist not found"));
    }

    public Journalist createJournalist(Journalist journalist) {
        return journalistRepository.save(journalist);
    }

    public Journalist updateJournalist(Long id, Journalist journalistDetails) {
        Journalist journalist = getJournalistById(id);
        journalist.setName(journalistDetails.getName());
        journalist.setAddress(journalistDetails.getAddress());
        journalist.setEmail(journalistDetails.getEmail());
        journalist.setPhoneNumber(journalistDetails.getPhoneNumber());
        return journalistRepository.save(journalist);
    }

    public void deleteJournalist(Long id) {
        journalistRepository.deleteById(id);
    }
}
