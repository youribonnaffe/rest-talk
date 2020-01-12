package com.github.youribonnaffe.jackson;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PetNoTypes {
    private final String birthday;
    private final int weight;
    private final String category;
}
