package educativity.algojava.search.excersise.dynamic;

public class IntervalSubstring {
    public static Object findSI(String m, String n, String p) {
        if (m.length() + n.length() != p.length())
            return false;

        boolean[][] lookupTable = new boolean[m.length() + 1][n.length() + 1];

        // for the empty pattern, we have one matching

        for (int mIndex = 0; mIndex <= m.length(); mIndex++) {
            for (int nIndex = 0; nIndex <= n.length(); nIndex++) {
                // if 'm' and 'n' are empty, then 'p' must have been empty too.
                if (mIndex == 0 && nIndex == 0)
                    lookupTable[mIndex][nIndex] = true;

                    // if 'm' is empty, we need to check the interleaving with 'n' only
                else if (mIndex == 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
                    lookupTable[mIndex][nIndex] = lookupTable[mIndex][nIndex - 1];

                    // if 'n' is empty, we need to check the interleaving with 'm' only
                else if (nIndex == 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))
                    lookupTable[mIndex][nIndex] = lookupTable[mIndex - 1][nIndex];

                else {
                    // if the letter of 'm' and 'p' match, we take whatever is matched till mIndex-1
                    if (mIndex > 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))
                        lookupTable[mIndex][nIndex] = lookupTable[mIndex - 1][nIndex];

                    // if the letter of 'n' and 'p' match, we take whatever is matched till nIndex-1 too
                    // note the '|=', this is required when we have common letters
                    if (nIndex > 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
                        lookupTable[mIndex][nIndex] |= lookupTable[mIndex][nIndex - 1];
                }
            }
        }
        return lookupTable[m.length()][n.length()];
    }

    public static void main(String[] args) {
        System.out.println(IntervalSubstring.findSI("aabcc","dbbca","aadbbcbcac"));
    }
}
