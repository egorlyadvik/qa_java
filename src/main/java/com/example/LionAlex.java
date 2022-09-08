package com.example;

import java.util.List;

public class LionAlex extends Lion {

    public LionAlex() throws Exception {
        super(new Feline(), "Самец");
    }

    public List<String> getFriends() {
        return List.of("Зебра Марти, Бегемотиха Глория, Жираф Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
