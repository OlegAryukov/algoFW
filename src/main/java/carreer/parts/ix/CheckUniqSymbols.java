package carreer.parts.ix;

import java.util.HashSet;

public class CheckUniqSymbols {

    //не очень верно(доп структура данных), но рабоче
    public boolean checkThatAllSymbolsUniq(String str) {
        HashSet<Character> characterSet = new HashSet<Character>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            characterSet.add(c);
        }
        return characterSet.size() == chars.length;
    }

    //рабоче но слишком долго
    public boolean checkWithoutNewStruct(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
        }
        return count == 0;
    }

    //Worked
    public boolean isUniq(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] chars = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int var = str.charAt(i);
            if(chars[var]){
                return false;
            }
            chars[var] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckUniqSymbols checkUniqSymbols = new CheckUniqSymbols();
        System.out.println(checkUniqSymbols.checkThatAllSymbolsUniq("abcdabefd"));
        System.out.println(checkUniqSymbols.checkThatAllSymbolsUniq("abcdef"));

        System.out.println(checkUniqSymbols.checkWithoutNewStruct("abcdabefd"));
        System.out.println(checkUniqSymbols.checkWithoutNewStruct("abcdef"));

        System.out.println(checkUniqSymbols.isUniq("abcdabefd"));
        System.out.println(checkUniqSymbols.isUniq("abcdef"));
    }
}
