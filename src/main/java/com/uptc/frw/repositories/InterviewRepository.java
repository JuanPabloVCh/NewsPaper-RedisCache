package com.uptc.frw.repositories;

import com.uptc.frw.models.Interview;
import com.uptc.frw.models.key.InterviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, InterviewId> {

}
