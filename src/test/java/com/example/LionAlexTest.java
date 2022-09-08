package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LionAlexTest {

    private LionAlex lionAlex;

    @Before
    public void lionAlexInit() throws Exception {
        lionAlex = new LionAlex();
    }

    @Test
    public void getFriendsReturnsFriendsOfAlex() {
        assertEquals(List.of("Зебра Марти, Бегемотиха Глория, Жираф Мелман"), lionAlex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsNewYorkZoo() {
        assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() {
        assertEquals(0, lionAlex.getKittens());
    }
}