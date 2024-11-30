package com.jn.slidingwindow;


/*
1358. 包含所有三种字符的子字符串数目
中等
相关标签
相关企业
提示
给你一个字符串 s ，它只包含三种字符 a, b 和 c 。

请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 */
public class sd1358 {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int aws = 0;

        for (int rigtht = 0; rigtht < s.length(); rigtht++) {
            char rightCur = s.charAt(rigtht);
            if (rightCur == 'a') count[0]++;
            if (rightCur == 'b') count[1]++;
            if (rightCur == 'c') count[2]++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                //这里表示的是包含窗口的所有子串都满足条件
                aws += s.length() - rigtht;

                char leftCur = s.charAt(left);
                if (leftCur == 'a') count[0]--;
                if (leftCur == 'b') count[1]--;
                if (leftCur == 'c') count[2]--;
                left++;
            }
        }

        return aws;
    }

    //错误示范，脑袋不太清醒
    public int numberOfSubstrings2(String s) {
        int aws = -1;
        char[] chars = new char[3];

        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            if (cur == 'a') {chars[0]++;}
            if (cur == 'b') {chars[1]++;}
            if (cur == 'c') {chars[2]++;}

            for (int left = 0; left < right; left++) {
                char leftCur = s.charAt(left);
                if (leftCur == 'a') {chars[0]--;}
                if (leftCur == 'b') {chars[1]--;}
                if (leftCur == 'c') {chars[2]--;}

                if (chars[0] >=1 && chars[1] >=1 && chars[2] >=1) {
                    aws++;
                }
            }
        }

        return aws;
    }
    public int numberOfSubstrings3(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[3];
        for (char c : s) {
            cnt[c - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[s[left] - 'a']--;
                left++;
            }
            ans += left;
        }
        return ans;
    }

//    作者：灵茶山艾府
//    链接：https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/solutions/2990226/mo-ban-yue-chang-yue-he-fa-xing-hua-dong-2g7a/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
