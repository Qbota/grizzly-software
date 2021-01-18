package com.cembrzynski.clinic.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinGeneratorTest {

    @Test
    public void shouldGeneratePinInBounds(){
         int lowBound = 1000;
         int highBound = 9999;

         int pin = PinGenerator.generatePinNumber();

         assertTrue(pin >= lowBound);
         assertTrue(pin <= highBound);
    }

}