package com.kerem.mockito.mockitodemo.business;

public class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 15, 5};
    }
}
