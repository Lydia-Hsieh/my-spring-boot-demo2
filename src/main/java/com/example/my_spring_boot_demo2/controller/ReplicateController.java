package com.example.my_spring_boot_demo2.controller;

import com.example.my_spring_boot_demo2.pojo.ClockRecordRequest;
import com.example.my_spring_boot_demo2.service.ClockStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReplicateController {

    @Autowired
    private ClockStatisticsService clockStatisticsService;

//    @PostMapping("/test")
//    public ResponseEntity<Object> testDb2(@RequestBody ClockRecordRequest request) {
//        clockStatisticsService.insertRecord(request);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/testGetAll")
//    public ResponseEntity<Object> testGetAll() {
//        Map<String, Object> allFromTwoDbs = clockStatisticsService.getAllFromTwoDbs();
//        return ResponseEntity.ok(allFromTwoDbs);
//    }

    @GetMapping("/replicate")
    public ResponseEntity<Object> replicateData() {
        clockStatisticsService.replicateStatisticsFromDb1ToDb2();
        return ResponseEntity.ok().build();
    }
}
