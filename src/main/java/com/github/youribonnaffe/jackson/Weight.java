package com.github.youribonnaffe.jackson;

import lombok.Value;

@Value
public class Weight {
    private final int weightInKilograms;

    public static Weight kilograms(int weightInKilograms) {
        return new Weight(weightInKilograms);
    }
}
