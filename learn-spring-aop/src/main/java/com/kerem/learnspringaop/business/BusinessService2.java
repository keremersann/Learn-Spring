package com.kerem.learnspringaop.business;

import com.kerem.learnspringaop.repository.DataService;
import com.kerem.learnspringaop.repository.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {
    private DataService2 dataService2;
    public BusinessService2(DataService2 dataService2){
        this.dataService2 = dataService2;
    }

    public int getTheMaximumNumber2(){
        int[] numbers = this.dataService2.retrieveNumbers2();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //throw new RuntimeException("Something went wrong!");
        return Arrays.stream(numbers).max().orElse(0);
    }
}
