package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class LionTest {

    @RunWith(MockitoJUnitRunner.class)
    public static class NotParameterizedLionTest {

        private Lion lion;
        private final String lionDefaultSex = "Самец";

        @Mock
        Feline felineMock;

        @Test
        public void getKittensReturnsOne() throws Exception {
            lion = new Lion(felineMock, lionDefaultSex);
            Mockito.when(felineMock.getKittens()).thenReturn(1);
            assertEquals(1, lion.getKittens());
            Mockito.verify(felineMock).getKittens();
        }

        @Test
        public void getFoodReturnsFoodForPredator() throws Exception {
            lion = new Lion(felineMock, lionDefaultSex);
            Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
            Mockito.verify(felineMock).getFood("Хищник");
        }

        @Test
        public void lionCreationWithNonExistentSexThrowsException() {
            try {
                lion = new Lion(felineMock, " ");
            } catch (Exception e) {
                assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
            }
        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizedLionTest {

        private Lion lion;
        private final String lionSex;
        private final boolean expected;

        @Rule
        public final MockitoRule mockitoRule = MockitoJUnit.rule();

        @Mock
        Feline felineMock;

        public ParameterizedLionTest(String lionSex, boolean expected) {
            this.lionSex = lionSex;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "Тестовые данные: Пол = {0}, Наличие гривы = {1}")
        public static Object[][] getLionData() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false}
            };
        }

        @Before
        public void lionInit() throws Exception {
            lion = new Lion(felineMock, lionSex);
        }

        @Test
        public void doesHaveManeReturnsCorrectResult() {
            assertEquals(expected, lion.doesHaveMane());
        }
    }
}