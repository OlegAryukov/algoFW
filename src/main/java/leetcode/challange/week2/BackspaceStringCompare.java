package leetcode.challange.week2;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {

//        Character firstCharAfterBackspaceS = null;
//        Character firstCharAfterBackspaceT = null;
//        boolean foundFirst = false;
//        boolean foundSecond = false;
//        if(S.length()==1){
//            firstCharAfterBackspaceS = S.charAt(0);
//        } else {
//            for (int i = S.length()-1; i > -1 ; i--) {
//                if(S.charAt(i) == '#'){
//                    foundFirst = true;
//                    if(i!=S.length()-1) {
//                        firstCharAfterBackspaceS = S.charAt(i+1);
//                        break;
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//
//        if(T.length()==1){
//            firstCharAfterBackspaceT = T.charAt(0);
//        } else {
//            for (int i = T.length()-1; i > -1 ; i--) {
//                if(T.charAt(i) == '#'){
//                    foundSecond = true;
//                    if(i!=T.length()-1){
//                        firstCharAfterBackspaceT = T.charAt(i+1);
//                        break;
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//        if(foundFirst && foundSecond) {
//
//            if (firstCharAfterBackspaceS == null && firstCharAfterBackspaceT == null) {
//                return true;
//            }
//            return (firstCharAfterBackspaceS == null || firstCharAfterBackspaceT == null) ? false : firstCharAfterBackspaceS.equals(firstCharAfterBackspaceT);
//        }
        return false;

    }

    public static void main(String[] args) {
        String s = new String("xywrrmp");
        String t = new String("xywrrm#p");
        BackspaceStringCompare.backspaceCompare(s,t);
    }
}
