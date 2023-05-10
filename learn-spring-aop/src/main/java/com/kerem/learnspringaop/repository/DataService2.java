package com.kerem.learnspringaop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    public int[] retrieveNumbers(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new int[] {11,22,33,44,55};
    }
}
