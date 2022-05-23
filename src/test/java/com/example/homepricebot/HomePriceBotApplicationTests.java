package com.example.homepricebot;

import com.example.homepricebot.entity.Houses;
import com.example.homepricebot.service.HousesService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class HomePriceBotApplicationTests {

    @MockBean
    private static HousesService housesService;

    static void mockHouse() {
        Houses house = new Houses(1L, "House 1");
        Mockito.when(housesService.getHouseById(Mockito.anyLong())).thenReturn(house);
    }

    @Test
    void getHouseTest() {
        mockHouse();
        Houses response = housesService.getHouseById(1L);
        assertEquals("House 1", response.getName());

    }

}
