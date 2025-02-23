package com.example.demo.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodsUtilsTest {

    private MethodsUtils methodsUtils;

    @BeforeEach
    void setUp() {
        methodsUtils = new MethodsUtils();
    }

    @Test
    void add() {

        assertEquals(5, methodsUtils.add(2, 3));
    }


    @Test
    void subtract() {

        assertEquals(2, methodsUtils.subtract(5, 3));
    }

    @Test
    void multiply() {

        assertEquals(6, methodsUtils.multiply(2, 3));
    }
}