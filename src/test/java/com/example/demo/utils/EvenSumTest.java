package com.example.demo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenSumTest {

    // Test 1: Biên nhỏ nhất (Minimum Boundary)
    @Test
    public void testFirstEvenNumber() {
        assertEquals(0, EvenSum.calculateEvenSum(2));
    }

    // Test 2: Biên lớn nhất (Maximum Boundary)
    @Test
    public void testLastEvenNumber() {
        assertEquals(482, EvenSum.calculateEvenSum(50));
    }

    // Test 3: Phân vùng tương đương với số chẵn bình thường
    @Test
    public void testNormalEvenNumber() {
        assertEquals(22, EvenSum.calculateEvenSum(10));
    }

    // Test 4: Kiểm tra khi có số bị bỏ qua (chia hết cho 8)
    @Test
    public void testExcludedNumber() {
        assertEquals(86, EvenSum.calculateEvenSum(20));
    }

    // Test 5: Kiểm tra số 8 (bị bỏ qua)
    @Test
    public void testFirstExcludedNumber() {
        assertEquals(12, EvenSum.calculateEvenSum(8));
        // 2 + 4 + 6 = 12 (8 bị bỏ qua)
    }

    // Test 6: Kiểm tra với số nhỏ hơn 2
    @Test
    public void testNumberLessThanTwo() {
        assertEquals(0, EvenSum.calculateEvenSum(1));
    }

}