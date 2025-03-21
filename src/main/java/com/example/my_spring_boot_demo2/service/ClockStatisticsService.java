package com.example.my_spring_boot_demo2.service;

import com.example.my_spring_boot_demo2.entity.db1.ClockStatistics1_Entity;
import com.example.my_spring_boot_demo2.entity.db2.ClockRecord2_Entity;
import com.example.my_spring_boot_demo2.entity.db2.ClockStatistics2_Entity;
import com.example.my_spring_boot_demo2.pojo.ClockRecordRequest;
import com.example.my_spring_boot_demo2.repository.db1.ClockRecord1Repository;
import com.example.my_spring_boot_demo2.repository.db1.ClockStatistics1Repository;
import com.example.my_spring_boot_demo2.repository.db2.ClockRecord2Repository;
import com.example.my_spring_boot_demo2.repository.db2.ClockStatistics2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClockStatisticsService {

    @Autowired
    private ClockRecord2Repository clockRecord2Repository;
    @Autowired
    private ClockRecord1Repository clockRecord1Repository;
    @Autowired
    private ClockStatistics1Repository clockStatistics1Repository;
    @Autowired
    private ClockStatistics2Repository clockStatistics2Repository;

    public void insertRecord(ClockRecordRequest request) {
        ClockRecord2_Entity clockRecord = new ClockRecord2_Entity();
        clockRecord.setUserId(request.getUserId());
        clockRecord.setCreateTime(request.getCreateTime());
        clockRecord.setRemark(request.getRemark());
        clockRecord2Repository.save(clockRecord);
    }

    public Map<String, Object> getAllFromTwoDbs() {
        Map<String, Object> map = new HashMap<>();
        map.put("db1 record", clockRecord1Repository.findAll());
        map.put("db2 record", clockRecord2Repository.findAll());
        return map;
    }

    @Transactional(value = "db2TransactionManager")
    public void replicateStatisticsFromDb1ToDb2() {
        List<ClockStatistics1_Entity> statisticsFromDb1 = clockStatistics1Repository.findAll();
        List<ClockStatistics2_Entity> convertList = statisticsFromDb1.stream()
                .map(ClockStatistics2_Entity::new)
                .toList();
        clockStatistics2Repository.saveAll(convertList);

        //testing rollback
//        List<ClockStatistics2_Entity> all = clockStatistics2Repository.findAll();
//        int k = 1/0;
    }
}
