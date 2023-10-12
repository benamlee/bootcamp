package com.example.benproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.service.CompanyProfileService;

@Component
@EnableScheduling
public class SchedulerTaskConfig {
    
    public static boolean start = false;
    
    @Autowired
    private CompanyProfileService companyProfileService;

    // @Scheduled(fixedRate = 8000) // 60 sec
    // public void fixedRateTask() throws InterruptedException, FinnhubException {
    //     if (start) { // after app start runner saved, start = true
    //         companyProfileService.refresh();
    //         System.out.println("insert new quote");
    //     }
    // }

}

