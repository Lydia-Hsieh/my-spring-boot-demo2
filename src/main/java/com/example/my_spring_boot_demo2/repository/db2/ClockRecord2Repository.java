package com.example.my_spring_boot_demo2.repository.db2;


import com.example.my_spring_boot_demo2.entity.db2.ClockRecord2_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ClockRecord2Repository extends JpaRepository<ClockRecord2_Entity, String> {

    Optional<ClockRecord2_Entity> findFirstByUserIdAndCreateTimeBetweenOrderByCreateTimeAsc(String userId, LocalDateTime dateStart, LocalDateTime dateEnd);

    Optional<ClockRecord2_Entity> findFirstByUserIdAndCreateTimeBetweenOrderByCreateTimeDesc(String userId, LocalDateTime dateStart, LocalDateTime dateEnd);
}
