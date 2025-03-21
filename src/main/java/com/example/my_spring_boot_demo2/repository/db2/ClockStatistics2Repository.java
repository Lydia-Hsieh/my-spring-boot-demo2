package com.example.my_spring_boot_demo2.repository.db2;


import com.example.my_spring_boot_demo2.entity.db2.ClockStatistics2_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockStatistics2Repository extends JpaRepository<ClockStatistics2_Entity, String> {
}
