package com.connect.model;

import org.junit.Assert;
import org.junit.Test;

public class LinkTest {
    @Test
    public void equalsShouldReturnTrueIfIdentifierAreMatching() {
        final Link link1 = new Link("test1");
        final Link link2 = new Link("test1");
        Assert.assertEquals(link1, link2);
    }

    @Test
    public void equalsShouldReturnFalseIfIdentifierAreNotMatching() {
        final Link link1 = new Link("test1");
        final Link link2 = new Link("test2");
        Assert.assertNotEquals(link1, link2);
    }
}