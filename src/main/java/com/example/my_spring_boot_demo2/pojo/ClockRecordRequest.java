package com.example.my_spring_boot_demo2.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ClockRecordRequest {

    private String userId;
    private LocalDateTime createTime;
    private String remark;
}
