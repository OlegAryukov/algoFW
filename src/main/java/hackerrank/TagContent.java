package hackerrank;

import java.util.LinkedList;
import java.util.Scanner;

public class TagContent {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        class Pair{
           public String key;
           public String value;

            public Pair(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }
        LinkedList<Pair> queue = new LinkedList<>();
        while (testCases > 0) {
            String line = in.nextLine();
            if (line.length() > 5) {
                boolean startingCloserTag = false;
                char[] src = line.toCharArray();
                StringBuilder sb = new StringBuilder();
                String tmp = null;
                for (char c : src) {
                    switch (c){
                        case ('<'):
                            if(queue.isEmpty()){
                                sb.append(c);
                            } else {
                                if(sb.length() == 0){
                                    sb.append(c);
                                } else {
                                    queue.add(new Pair("Content", sb.toString()));
                                    sb.delete(0, sb.length());
                                    sb.append(c);
                                }
                            }
                            break;
                        case('>'):
                            sb.append(c);
                            if(startingCloserTag){
                                queue.add(new Pair("CloserTag", sb.toString()));
                                sb.delete(0, sb.length());
                                startingCloserTag = false;
                            } else {
                                queue.add(new Pair("OpenTag", sb.toString()));
                                sb.delete(0, sb.length());
                            }
                            break;
                        case ('/'):
                            startingCloserTag = true;
                            sb.append(c);
                            break;
                         default:
                             sb.append(c);
                    }
                }
            }
            testCases--;
        }
        queue.forEach(pair -> System.out.println(pair.key + " : " + pair.value));
    }
}
