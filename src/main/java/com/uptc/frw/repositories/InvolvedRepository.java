package com.uptc.frw.repositories;

import com.uptc.frw.models.Involved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface InvolvedRepository extends JpaRepository<Involved, Long> {

}
