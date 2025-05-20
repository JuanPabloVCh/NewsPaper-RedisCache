package com.uptc.frw.repositories;

import com.uptc.frw.models.NewsSupply;
import com.uptc.frw.models.key.NewsSupplyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsSupplyRepository extends JpaRepository<NewsSupply, NewsSupplyId> {

}
