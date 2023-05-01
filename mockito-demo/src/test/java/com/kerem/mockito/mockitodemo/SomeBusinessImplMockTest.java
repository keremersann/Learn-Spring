package com.kerem.mockito.mockitodemo;

import com.kerem.mockito.mockitodemo.business.DataService;
import com.kerem.mockito.mockitodemo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {
    @Mock
    private DataService dataService;
    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    public void testThreeValue(){
        when(dataService.retrieveAllData()).thenReturn(new int[] {25, 15 ,5});
        assertEquals(25, someBusiness.retrieveGreatestAmongAll());
    }
    @Test
    public void testOneValue(){
        when(dataService.retrieveAllData()).thenReturn(new int[] {35});
        assertEquals(35, someBusiness.retrieveGreatestAmongAll());
    }
    @Test
    public void testEmptyArray(){
        when(dataService.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, someBusiness.retrieveGreatestAmongAll());
    }
}
