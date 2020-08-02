package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From zero temperature'; 25; -3; 0; 1",
                    "'From before max temperature'; 25; -3; 24; 25",
                    "'From max temperature'; 25; -3; 25; 25",
            }
            , delimiter = ';'
    )
    public void shouldIncreaseCurrentTemperature(String name, int max, int min, int current, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setName(name);
        conditioner.setMaxTemperature(max);
        conditioner.setMinTemperature(min);
        conditioner.setCurrentTemperature(current);

        conditioner.increaseCurrentTemperature();
        assertEquals(expected, conditioner.getCurrentTemperature());

    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From zero temperature'; 25; -3; 0; -1",
                    "'From before last temperature'; 25; -3; -2; -3",
                    "'From min temperature'; 25; -3; -3; -3",
            }
            , delimiter = ';'
    )
    public void shouldDecreaseCurrentTemperature(String name, int max, int min, int current, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setName(name);
        conditioner.setMaxTemperature(max);
        conditioner.setMinTemperature(min);
        conditioner.setCurrentTemperature(current);

        conditioner.decreaseCurrentTemperature();
        assertEquals(expected, conditioner.getCurrentTemperature());

    }
}

