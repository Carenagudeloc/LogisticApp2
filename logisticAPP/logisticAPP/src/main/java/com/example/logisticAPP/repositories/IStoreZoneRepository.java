package com.example.logisticAPP.repositories;

import com.example.logisticAPP.models.StoreZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreZoneRepository extends JpaRepository<StoreZone, Integer> {
}
