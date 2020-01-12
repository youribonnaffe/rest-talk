package com.github.youribonnaffe.jackson;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Pet {
    private final LocalDate birthday;
    private final Weight weight;
    private final Category category;
}
