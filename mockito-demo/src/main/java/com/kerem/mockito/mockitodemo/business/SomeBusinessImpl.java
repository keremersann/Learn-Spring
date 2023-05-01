package com.kerem.mockito.mockitodemo.business;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int retrieveGreatestAmongAll(){
        int[] numbers = dataService.retrieveAllData();
        int max = Integer.MIN_VALUE;
        for (int number: numbers) {
            if(number > max){
                max = number;
            }
        }
        return max;
    }
}

