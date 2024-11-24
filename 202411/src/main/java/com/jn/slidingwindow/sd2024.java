package com.jn.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/*
2024. 考试的最大困扰度
中等
相关标签
相关企业
提示
一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。

给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：

每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 */
public class sd2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(consecutiveAnswers(answerKey, k, 'T'), consecutiveAnswers(answerKey, k, 'F'));
    }

    public int consecutiveAnswers(String answerKey, int k, char c) {
        int maxResult = 0;
        int left = 0;
        int count = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) != c) {
                count++;
            }

            while (count > k) {
                if (answerKey.charAt(left) != c) {
                    count--;
                }
                left++;
            }

            maxResult = Math.max(maxResult, right - left + 1);
        }

        return maxResult;
    }

//    //一开始的错误示范，想在一次便利中统计出两个字符做不出来
//    public int maxConsecutiveAnswers2(String answerKey, int k) {
//        int left = 0;
//        int count = 1;
//        int maxResult = 0;
//
//        for (int right = 1; right < answerKey.length(); right++) {
//            if (answerKey.charAt(right) == answerKey.charAt(right - 1)) {
//                count++;
//                maxResult = Math.max(maxResult, count);
//            } else {
//                k--;
//            }
//
//            while (k < 0) {
//                if (answerKey.charAt(left) == answerKey.charAt(right)) {
//                    k++;
//                }
//                left++;
//            }
//        }
//
//        return maxResult;
//    }

    //其实在一次遍历中统计两个字符还是做得出来的
    //总共有每种字符都有两种情况：>k和<=k，所有总共有2*2=4种情况
    //其中有三种情况是合理的，分别为：都<k，T<k&&F>k，T>k&&F<k
    //只有一种情况是不合理的，也就是：T>k&&F>k
    public int maxConsecutiveAnswers2(String answerKey, int k) {
        int maxResult = 0;
        int left = 0;
        int countT = 0;
        int countF = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) != 'T') {
                countT++;
            }

            if (answerKey.charAt(right) != 'F') {
                countF++;
            }

            while (countT > k && countF > k) {
                if (answerKey.charAt(left) != 'T') {
                    countT--;
                }

                if (answerKey.charAt(left) != 'F') {
                    countF--;
                }

                left++;
            }

            maxResult = Math.max(maxResult, right - left + 1);
        }

        return maxResult;
    }
}
