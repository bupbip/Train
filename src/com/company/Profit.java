package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Profit {

    public static void main(String[] args) {

        int[] nums_initial = new int[] {1, 34, 55, 231, 144, 233, 45, 377};

        System.out.println(my(nums_initial, 2));
    }

    public static int my(int[] prices, int n) {
        return find(new ArrayList<Integer>(), prices, n*2, 0);
    }

    public static int find(ArrayList<Integer> deals, int[] prices, int num, int start) {
        if (num == 0) {
            int sum = 0;
            for (int i = 0; i < deals.size(); i+=2) {
                sum += (prices[deals.get(i+1)] - prices[deals.get(i)]);
            }
            System.out.println(deals + " - " + sum);
            return sum;
        }

        int max = -1;
        for (int i = start; i < prices.length; ++i) {
            ArrayList<Integer> newDeals = new ArrayList<>();
            for (Integer deal: deals) {
                newDeals.add(deal);
            }
            newDeals.add(i);

            int temp = find(newDeals, prices, num - 1, i + 1);
            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }
}
