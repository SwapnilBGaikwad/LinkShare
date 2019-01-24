package com.connect.service;

import org.junit.Assert;
import org.junit.Test;

public class RandomGeneratorTest {
    @Test
    public void shouldGenerateRandomStringOfLength10() {
        final RandomGenerator generator = new RandomGenerator();
        Assert.assertEquals(10, generator.get().length());
    }
}