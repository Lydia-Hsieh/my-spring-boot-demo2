package com.example.my_spring_boot_demo2.entity.db1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "CLOCK_RECORD")
@Getter
@Setter
public class ClockRecord1_Entity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;

    @Column(name = "REMARK")
    private String remark;
}
