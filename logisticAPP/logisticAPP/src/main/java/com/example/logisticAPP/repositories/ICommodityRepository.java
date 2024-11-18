package com.example.logisticAPP.repositories;

import com.example.logisticAPP.models.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommodityRepository extends JpaRepository<Commodity, Integer> {

}
