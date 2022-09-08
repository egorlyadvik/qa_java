package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void felineInit() {
        feline = new Feline();
    }

    @Test
    public void eatMeatReturnsFoodForPredator() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgumentReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArgumentsReturnArgumentValue() {
        int kittensCount = 5;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}