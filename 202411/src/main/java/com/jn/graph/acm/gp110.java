package com.jn.graph.acm;

import java.util.*;

/*
110. 字符串接龙
题目描述
字典 strList 中从字符串 beginStr 和 endStr 的转换序列是一个按下述规格形成的序列：



1. 序列中第一个字符串是 beginStr。

2. 序列中最后一个字符串是 endStr。

3. 每次转换只能改变一个字符。

4. 转换过程中的中间字符串必须是字典 strList 中的字符串，且strList里的每个字符串只用使用一次。



给你两个字符串 beginStr 和 endStr 和一个字典 strList，找到从 beginStr 到 endStr 的最短转换序列中的字符串数目。如果不存在这样的转换序列，返回 0。
 */
public class gp110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String beginStr = scanner.next();
        String endStr = scanner.next();

        scanner.nextLine();

        List<String> listStr = new ArrayList<>();

        listStr.add(beginStr);
        listStr.add(endStr);

        for (int i = 0; i < n; i++) {
            listStr.add(scanner.nextLine());
        }

        int result = bfs(beginStr, endStr, listStr);

        System.out.println(result);
    }

    static int bfs(String beginWord, String endWord, List<String> wordList) {
        //记录当前长度，默认一开始是1
        int len = 1;
        //记录listStr中存在的字符串
        Set<String> set = new HashSet<>(wordList);
        //记录字符串是否访问过
        Set<String> visited = new HashSet<>();
        //用队列表示当前行
        Queue<String> queue = new LinkedList<>();
        //加入并标记
        queue.offer(beginWord);
        visited.add(beginWord);
        //加入一个null表示当前行结束
        queue.offer(null);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    //重复while循环外的初始化操作
                    len++;
                    queue.offer(null);
                }
                continue;
            }

            char[] charArray = node.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                char old = charArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String newStr = new String(charArray);

                    if (set.contains(newStr) && !visited.contains(newStr)) {
                        queue.offer(newStr);
                        visited.add(newStr);

                        //如果找到endStr则直接返回
                        if (newStr.equals(endWord)) {
                            return len + 1;
                        }
                    }
                }

                charArray[i] = old;
            }
        }
        return 0;
    }
}
