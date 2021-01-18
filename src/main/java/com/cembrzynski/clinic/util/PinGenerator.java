package com.cembrzynski.clinic.util;

import java.util.Random;

public final class PinGenerator {

    private static final int MIN_PIN_VALUE = 1000;
    private static final int MAX_PIN_VALUE = 9999;
    private static final Random RANDOM_GENERATOR = new Random();

    private PinGenerator(){
        //Should be private and empty
    }

    public static int generatePinNumber(){
        return RANDOM_GENERATOR
                .ints(MIN_PIN_VALUE, MAX_PIN_VALUE)
                .findFirst()
                .getAsInt();
    }
}
