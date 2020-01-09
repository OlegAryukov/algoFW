package seidgvik.sort;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortTemplate {
    public static void sort(Comparable[] input){

    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    private static void exchange(Comparable[] input, int i, int j){
        Comparable temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void show(Comparable[] input){
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        final  String PATH = "C:/MyJavaCode/example.txt";
        InputStreamReader is = new InputStreamReader(System.in);
        try {
            List<String> input = Files.lines(Paths.get(PATH), StandardCharsets.UTF_8).collect(Collectors.toList());
            String[] a = new String[input.size()];
            sort(input.toArray(a));
            show(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
