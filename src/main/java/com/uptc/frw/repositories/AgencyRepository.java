package com.uptc.frw.repositories;

import com.uptc.frw.models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
}
