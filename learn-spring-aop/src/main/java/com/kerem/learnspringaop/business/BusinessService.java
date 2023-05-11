package com.kerem.learnspringaop.business;

import com.kerem.learnspringaop.annotations.TrackTime;
import com.kerem.learnspringaop.repository.DataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {
    private DataService dataService;
    public BusinessService(DataService dataService){
        this.dataService = dataService;
    }

    @TrackTime
    public int getTheMaximumNumber(){
        int[] numbers = this.dataService.retrieveNumbers();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //throw new RuntimeException("Something went wrong!");
        return Arrays.stream(numbers).max().orElse(0);
    }
}
