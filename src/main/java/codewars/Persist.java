package codewars;

class Persist {
    //Bad solution
    public static int persistence(long n) {
        int count = 0;
        int res = (int) n;
        long source = n;
        while (res > 10){
            char[] srcArr = String.valueOf(source).toCharArray();
            long tmp = Long.valueOf(String.valueOf(srcArr[0]));
            for(int i = 1; i < srcArr.length; i++){
                tmp = tmp * Long.valueOf(String.valueOf(srcArr[i]));
            }
            res = (int) tmp;
            source = tmp;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Persist p = new Persist();
        System.out.println(Persist.persistence(39));
    }
}
