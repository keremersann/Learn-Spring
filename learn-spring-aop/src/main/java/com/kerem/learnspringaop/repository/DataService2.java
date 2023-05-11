package com.kerem.learnspringaop.repository;

import com.kerem.learnspringaop.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    @TrackTime
    public int[] retrieveNumbers2(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new int[] {11,22,33,44,55};
    }
}
