package com.uptc.frw.services;

import com.uptc.frw.models.Agency;
import com.uptc.frw.repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    public Agency getAgencyById(Long id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found"));
    }

    public Agency createAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    public Agency updateAgency(Long id, Agency agencyDetails) {
        Agency agency = getAgencyById(id);
        agency.setName(agencyDetails.getName());
        agency.setCreationDate(agencyDetails.getCreationDate());
        return agencyRepository.save(agency);
    }

    public void deleteAgency(Long id) {
        agencyRepository.deleteById(id);
    }
}
