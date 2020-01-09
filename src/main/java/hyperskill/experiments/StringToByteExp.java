package hyperskill.experiments;

import java.util.ArrayList;
import java.util.List;

public class StringToByteExp {
    public static void main(String[] args) {
        String a = "processes";
        String b = "processes";
        byte[] aByte = a.getBytes();
        byte[] bByte = b.getBytes();
        for (int i = 0; i < aByte.length; i++) {
            System.out.print(aByte[i]);
        }
        System.out.println("-----");

        for (int i = 0; i < bByte.length; i++) {
            System.out.print(bByte[i]);
        }

        List<String> strings = new ArrayList<>();
        strings.add("line");
        strings.add("LINE");
        StringToByteExp stringToByteExp = new StringToByteExp();
        stringToByteExp.strParser(strings);

    }

    public void strParser(List<String> stringList) {
        boolean isFinish = false;
        for (String str : stringList) {
            String b = new String(str.toUpperCase());
            if (str.compareTo(b) != 0) {
                System.out.println(b);
                continue;
            }
            break;
        }
        System.out.println("FINISHED");
    }
}
