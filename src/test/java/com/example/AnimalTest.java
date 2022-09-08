package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class AnimalTest {

    public static class NotParameterizedAnimalTest {

        private Animal animal;

        @Before
        public void animalInit() {
            animal = new Animal();
        }

        @Test
        public void getFamilyReturnsGeneralInformationAboutFamilies() {
            assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
        }

        @Test
        public void getFoodWithIncorrectFamilyThrowsException() {
            Exception e = assertThrows(Exception.class, () -> animal.getFood(" "));
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizedAnimalTest {

        private Animal animal;
        private final String animalKind;
        private final List<String> expected;

        public ParameterizedAnimalTest(String animalKind, List<String> expected) {
            this.animalKind = animalKind;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "Тестовые данные: Вид животного = {0}, Еда = {1}")
        public static Object[][] getAnimalData() {
            return new Object[][]{
                    {"Травоядное", List.of("Трава", "Различные растения")},
                    {"Хищник", List.of("Животные", "Птицы", "Рыба")}
            };
        }

        @Before
        public void animalInit() {
            animal = new Animal();
        }

        @Test
        public void getFoodReturnsCorrectKindOfFood() throws Exception {
            assertEquals(expected, animal.getFood(animalKind));
        }
    }
}