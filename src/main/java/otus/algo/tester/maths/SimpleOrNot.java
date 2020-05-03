package otus.algo.tester.maths;

public class SimpleOrNot {
    public boolean prime(long p) {
        int i = 0;
        for (int j = 3; j * j <= p; j+=2) {
            if (p % j == 0) {
                return false;
            }
        }
        return true;
    }

    public int primeCount(){
        int j = 0;
        for (int i = 2; i < 10000; i++) {
            if(prime(i)){
                j++;
            }
        }
        return j;
    }
}
