package java.SlidingWindow;

public class T125 {

    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sgood.append(s.charAt(i));
            }
        }
        int left = 0, right = sgood.length();
        while (left < right) {
            if (sgood.charAt(left) != sgood.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// 一个很妙的写法
// class Solution {
//     public boolean isPalindrome(String s) {
//         int length = s.length();
//         if (length == 1) {
//             return true;
//         }

//         int left = 0;
//         int right = length - 1;
//         while (left < right) {
//             while ((left < right) && !isValidCharacter(s.charAt(left))) {
//                 ++left;
//             }
//             while ((left < right) && !isValidCharacter(s.charAt(right))) {
//                 --right;
//             }
//             char leftC = s.charAt(left);
//             char rightC = s.charAt(right);
//             if (leftC != rightC) {
//                 if (isUpper(leftC)) {
//                     leftC = upper2Lower(leftC);
//                 }
//                 if (isUpper(rightC)) {
//                     rightC = upper2Lower(rightC);
//                 }
//                 if (leftC != rightC) {
//                     return false;
//                 }
//             }
//             ++left;
//             --right;
//         }
//         return true;
//     }

//     private boolean isDigits(char c) {
//         return (c >= '0') && (c <= '9');
//     }

//     private boolean isLower(char c) {
//         return (c >= 'a') && (c <= 'z');
//     }

//     private boolean isUpper(char c) {
//         return (c >= 'A') && (c <= 'Z');
//     }

//     private boolean isValidCharacter(char c) {
//         return isDigits(c) || isLower(c) || isUpper(c);
//     }

//     private char upper2Lower(char c) {
//         return (char)(c - 'A' + 'a');
//     }
// }