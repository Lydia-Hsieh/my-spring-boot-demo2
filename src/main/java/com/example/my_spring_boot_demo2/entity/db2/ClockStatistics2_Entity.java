package com.example.my_spring_boot_demo2.entity.db2;

import com.example.my_spring_boot_demo2.entity.db1.ClockStatistics1_Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CLOCK_STATISTICS")
@Getter
@Setter
public class ClockStatistics2_Entity implements Serializable {

    public ClockStatistics2_Entity() {
    }

    public ClockStatistics2_Entity(ClockStatistics1_Entity entity) {
        this.userId = entity.getUserId();
        this.recordDay = entity.getRecordDay();
        this.earliestTime = entity.getEarliestTime();
        this.latestTime = entity.getLatestTime();
        this.timeDiff = entity.getTimeDiff();
        this.createTime = entity.getCreateTime();
        this.remark = entity.getRemark();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "RECORD_DAY", nullable = false)
    private LocalDate recordDay;

    @Column(name = "EARLIEST_TIME")
    private LocalDateTime earliestTime;

    @Column(name = "LATEST_TIME")
    private LocalDateTime latestTime;

    @Column(name = "TIME_DIFF", nullable = false, precision = 5, scale = 2)
    private BigDecimal timeDiff;

    @Column(name = "CREATE_TIME", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "REMARK")
    private String remark;
}
