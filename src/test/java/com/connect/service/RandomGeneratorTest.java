package com.connect.service;

import org.junit.Assert;
import org.junit.Test;

public class RandomGeneratorTest {
    @Test
    public void shouldGenerateRandomStringOfLength10() {
        final RandomGenerator generator = new RandomGenerator();
        final String str = generator.get();
        System.out.println(str);
        Assert.assertEquals(10, str.length());
    }
}