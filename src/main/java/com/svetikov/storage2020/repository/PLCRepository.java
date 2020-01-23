package com.svetikov.storage2020.repository;

import com.svetikov.storage2020.models.PLCData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PLCRepository extends JpaRepository<PLCData,Integer> {

}
