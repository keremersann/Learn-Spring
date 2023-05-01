package com.kerem.mockito.mockitodemo;

import com.kerem.mockito.mockitodemo.business.DataService;
import com.kerem.mockito.mockitodemo.business.DataServiceStub;
import com.kerem.mockito.mockitodemo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {

    @Test
    public void test(){
        DataService service = new DataServiceStub();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(service);
        int result = someBusiness.retrieveGreatestAmongAll();
        assertEquals(25, result);
    }
}
