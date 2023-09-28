package com.lzq.algo;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(halveArray(new int[]{5, 19, 8, 1}));
    }
    

    public static int halveArray(int[] nums) {
        int res = 0, sum = 0;
        Arrays.sort(nums);
        int maxIndex = nums.length - 1;

        for (int num : nums) {
            sum += num;
        }
        double half = sum / 2.0;
        double sub = 0;

        while (half > sub && maxIndex > 0) {
            double temp = nums[maxIndex] / 2.0;
            sub += temp;
            res++;
            if (sub >= half) {
                break;
            }
            if (temp < nums[maxIndex - 1]) {
                maxIndex--;
            }
        }
        return res;
    }

    private static void test(int[] nums) {
        Long id = null;
        changeID(id);
        System.out.println(id);
    }

    private static void changeID(Long id) {
        id = 8888L;
    }
}