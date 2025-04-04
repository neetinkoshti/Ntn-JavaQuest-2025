package org.ntn.com.interviews;

public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {

        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices1 = new int[]{7,5,4,3,1};

        maxProfit(prices1);

    }

    private static void maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit =0;

        for(int i = 0; i < prices.length-1; i++){

            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if ((prices[i] -minPrice) > maxProfit ){
                maxProfit = prices[i] -minPrice;
            }
        }
        System.out.println("MaxProfit would be :"+maxProfit);
    }
}
