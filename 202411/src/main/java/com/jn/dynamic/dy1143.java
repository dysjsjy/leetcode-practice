package com.jn.dynamic;


/*
1143. 最长公共子序列
中等
相关标签
相关企业
提示
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class dy1143 {

    //正确示范
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //这里不太看得明白
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        return dp[text1.length()][text2.length()];
    }

    /*
    代码中的 `dp[i][j]` 表示字符串 `text1` 的前 `i` 个字符与字符串 `text2` 的前 `j` 个字符之间的最长公共子序列（LCS）的长度。

在 `else` 分支里：

```java
dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
```

这个逻辑的意义如下：

1. **如果当前字符不相等** (`text1.charAt(i - 1) != text2.charAt(j - 1)`)：
   - 我们有两种可能：
     - **忽略 `text1` 的当前字符**（即考虑 `text1` 的前 `i-1` 个字符和 `text2` 的前 `j` 个字符）。
       - 这种情况下最长公共子序列长度是 `dp[i - 1][j]`。
     - **忽略 `text2` 的当前字符**（即考虑 `text1` 的前 `i` 个字符和 `text2` 的前 `j-1` 个字符）。
       - 这种情况下最长公共子序列长度是 `dp[i][j - 1]`。
   - 由于我们希望找到最长的公共子序列，所以取这两种情况的较大值，即：
     ```java
     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
     ```

2. **总结**：
   - 当前两个字符不相等时，最长公共子序列的长度等于：
     - 忽略其中一个字符串的当前字符后的结果的最大值。

### 举个例子

假设 `text1 = "abcde"`，`text2 = "ace"`：

- 如果我们在 `i=2`，`j=3` 时，比较 `text1` 的 `'b'` 和 `text2` 的 `'e'`：
  - 它们不相等，怎么办？
  - 我们考虑两种选择：
    - 忽略 `'b'`，则参考 `dp[1][3]`，即 `'a'` 和 `'ace'` 的 LCS。
    - 忽略 `'e'`，则参考 `dp[2][2]`，即 `'ab'` 和 `'ac'` 的 LCS。
  - 取两者的最大值，作为当前 `dp[2][3]` 的值。

希望这样解释可以帮助你理解！😊
     */

    //错误示范
    public int longestCommonSubsequence2(String text1, String text2) {
        int maxResult = 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(1)) {
                dp[i][1] = Math.max(dp[i - 1][1 - 1] + 1, dp[i][1]);
            }
        }

        for (int i = 1; i < text2.length(); i++) {
            if (text2.charAt(i) == text1.charAt(1)) {
                dp[1][i] = Math.max(dp[1 - 1][i - 1] + 1, dp[1][i]);
            }
        }

        for (int i = 2; i < text1.length(); i++) {
            for (int j = 2; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j - 1] + 1, dp[i - 2][j - 2] + 1));
                    maxResult = Math.max(maxResult, dp[i][j]);
                }
            }
        }

        return maxResult;
    }
}
