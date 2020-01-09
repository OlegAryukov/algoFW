public class SubStringLengthCalc {

    public int subStringLengthCount(String str) {
        int mainCount = 1;
        int charCount = 1;
        char[] input = str.toCharArray();
        for (int i = 0; i < input.length; i = i + charCount) {
            charCount = 1;
            for (int j = i; j < input.length; j++) {
                if ((j + 1) < input.length && String.valueOf(input[j]).equals(String.valueOf(input[j + 1]))) {
                    charCount++;
                    continue;
                } else {
                    if (charCount > mainCount) {
                        mainCount = charCount;
                        break;
                    }
                }
                break;
            }
        }
        return mainCount;
    }
}
