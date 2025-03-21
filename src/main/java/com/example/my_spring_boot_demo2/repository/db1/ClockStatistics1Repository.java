package com.example.my_spring_boot_demo2.repository.db1;


import com.example.my_spring_boot_demo2.entity.db1.ClockStatistics1_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockStatistics1Repository extends JpaRepository<ClockStatistics1_Entity, String> {
}
