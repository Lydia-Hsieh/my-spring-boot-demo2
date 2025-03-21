package com.example.my_spring_boot_demo2.repository.db1;


import com.example.my_spring_boot_demo2.entity.db1.ClockRecord1_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ClockRecord1Repository extends JpaRepository<ClockRecord1_Entity, String> {

    Optional<ClockRecord1_Entity> findFirstByUserIdAndCreateTimeBetweenOrderByCreateTimeAsc(String userId, LocalDateTime dateStart, LocalDateTime dateEnd);

    Optional<ClockRecord1_Entity> findFirstByUserIdAndCreateTimeBetweenOrderByCreateTimeDesc(String userId, LocalDateTime dateStart, LocalDateTime dateEnd);
}
