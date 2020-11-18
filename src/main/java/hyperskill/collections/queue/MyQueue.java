package hyperskill.collections.queue;

import java.util.Scanner;
import java.util.Stack;

public class MyQueue {
    public static void main(String[] args) {
        String FIRST = "()";
        String SECOND = "[]";
        String THERD = "{}";
        boolean isCorrect = true;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(i==0){
                stringStack.push(String.valueOf(chars[i]));
                continue;
            }
            if(!stringStack.empty()){
                String tmp = stringStack.peek().concat(String.valueOf(chars[i]));
                if(tmp.equals(FIRST) || tmp.equals(SECOND) || tmp.equals(THERD)){
                    stringStack.pop();
                } else {
                    stringStack.push(String.valueOf(chars[i]));
                }
                continue;
            }
            if((chars.length - i)%2==0){
                stringStack.push(String.valueOf(chars[i]));
            } else {
                isCorrect = false;
                break;
            }
        }
        isCorrect = stringStack.empty() && isCorrect == true;
        System.out.println(isCorrect);
    }
}
