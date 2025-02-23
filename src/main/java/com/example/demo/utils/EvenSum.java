package com.example.demo.utils;

public class EvenSum {

    public static int calculateEvenSum(int n) {
        if (n < 2) {
            return 0; // Không có số chẵn nào nhỏ hơn 2
        }
        int sum = 0;
        for (int i = 2; i <= n; i += 2) { // Duyệt qua các số chẵn
            if (i % 8 != 0) { // Bỏ qua số chia hết cho 8
                sum += i;
            }
        }
        return sum;
    }
}
