package educativity.algojava.search.excersise.greedy;

public class MainPlatforms {
    public static int findPlatform(int[] arrival, int[] departure) {
        int maxPlat = 1;
        int[] lookUp = new int[2400];
        for (int j = arrival[0]; j < departure[0]; j++) {
            lookUp[j] = 1;
        }
        for (int i = 1; i < arrival.length; i++) {
            for (int j = arrival[i]; j < departure[i]; j++) {
                lookUp[j] = lookUp[j] + 1;
                maxPlat = maxPlat > lookUp[j] ? maxPlat : lookUp[j];
            }
        }
        return maxPlat;
    }
}
