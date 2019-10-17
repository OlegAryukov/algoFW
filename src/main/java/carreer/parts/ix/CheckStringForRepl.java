package carreer.parts.ix;

public class CheckStringForRepl {

    public boolean checkRepl(String a, String b) {
        int sumA = 0;
        int sumB = 0;

        if(a.length() != b.length()){
            return false;
        }

        for (int i = 0; i<a.length(); i++){
            sumA += a.charAt(i);
            sumB += b.charAt(i);
        }

        return sumA == sumB;
    }

    public static void main(String[] args) {
        CheckStringForRepl checkStringForRepl = new CheckStringForRepl();
        System.out.println(checkStringForRepl.checkRepl("aabbcc", "abcabc"));
        System.out.println(checkStringForRepl.checkRepl("aabbccdf", "abcabc"));
        System.out.println(checkStringForRepl.checkRepl("aabdfc", "abcabc"));
    }
}
