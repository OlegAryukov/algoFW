package yandex.kontest;
import java.io.*;

public class LongestOne{

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(r.readLine());
        int countOfRead = 0;
        int maxLongestOne = 0;
        int currCountOfOne = 0;
        while (countOfRead!=n){
            if(Integer.parseInt(r.readLine())!=1){
                maxLongestOne = Math.max(maxLongestOne, currCountOfOne);
                currCountOfOne = 0;
                countOfRead++;
                continue;
            }
            currCountOfOne++;
            countOfRead++;
        }


        System.out.println(maxLongestOne);
    }

}
