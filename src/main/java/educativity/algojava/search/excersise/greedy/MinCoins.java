package educativity.algojava.search.excersise.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class MinCoins {
    // a public collection of available coins
    public static int [] coins = {25, 10, 5, 1};

    public static  ArrayList<Integer> getMinCoins(int amount)  // function to recieve change in the form of coins
    {
        ArrayList<Integer> change = new ArrayList<Integer>();
        for (int i = 0; i < coins.length; i++) {
            if(amount==0){
                break;
            }
            while (coins[i] < amount){
                change.add(coins[i]);
                amount -= coins[i];
            }
        }
//        int[] availableCoins = Arrays.copyOf(coins, coins.length);
//        Arrays.sort(availableCoins);
        return change;
    }
}
