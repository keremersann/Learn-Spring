package com.kerem.learnspringaop.business;

import com.kerem.learnspringaop.repository.DataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {
    private DataService dataService;
    public BusinessService2(DataService dataService){
        this.dataService = dataService;
    }

    public int getTheMaximumNumber(){
        int[] numbers = this.dataService.retrieveNumbers();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //throw new RuntimeException("Something went wrong!");
        return Arrays.stream(numbers).max().orElse(0);
    }
}
