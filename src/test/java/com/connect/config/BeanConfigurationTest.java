package com.connect.config;

import com.connect.model.Credential;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BeanConfigurationTest {
    @Test
    public void testMapBean() {
        final BeanConfiguration configuration = new BeanConfiguration();
        final Map<String, Credential> map = configuration.getMap();
        Assert.assertEquals(new HashMap<>(), map);
    }
}