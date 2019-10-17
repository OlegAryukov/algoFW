package hackerrank;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.abs;

public class Solution {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stringStack = new Stack<>();
        while (sc.hasNext()) {
            String input = sc.next();
            if (stringStack.isEmpty()) {
                stringStack.push(input);
            } else {
                if (input.equals("(") || input.equals(")")) {
                    if (abs(stringStack.peek().toCharArray()[0] - input.toCharArray()[0]) == 0) {
                        stringStack.pop();
                        stringStack.push(input);
                    } else {
                    }
                    if(stringStack.isEmpty()){break;}
                } else if(input.equals("[") || input.equals("]")){
                    if (abs(stringStack.peek().toCharArray()[0] - input.toCharArray()[0]) == 2) {
                        stringStack.pop();
                        stringStack.push(input);
                    } else {
                    }
                    if(stringStack.isEmpty()){break;}
                } else if (input.equals("{") || input.equals("}")) {
                    if (abs(stringStack.peek().toCharArray()[0] - input.toCharArray()[0]) == 2) {
                        stringStack.pop();
                        if(stringStack.isEmpty()){break;}
                    } else {
                        stringStack.push(input);
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(stringStack.isEmpty());
    }
}
