package com.jn.graph.acm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class gp126 {

    static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2}; //骑士移动的x方向
    static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1}; //其实移动的y方向
    static final int BOARD_SIZE = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a1 = scanner.nextInt(), a2 = scanner.nextInt();
            int b1 = scanner.nextInt(), b2 = scanner.nextInt();
            System.out.println(aStar(a1, a2, b1, b2));
        }
        scanner.close();
    }

    //A*算法实现
    private static int aStar(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) {
            return 0;
        }

        //优先队列：按f = g + h升序
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.f));
        boolean[][] visited = new boolean[BOARD_SIZE + 1][BOARD_SIZE + 1]; //标记是否访问过

        //初始化节点
        pq.offer(new Node(startX, startY, 0, heuristic(startX, startY, endX, endY)));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int x = current.x, y = current.y;

            //如果当前节点时目标节点，返回步数
            if (x == endX && y == endY) {
                return current.g;
            }

            //标记当前节点已访问过
            if (visited[x][y]) continue;
            visited[x][y] = true;

            //尝试骑士的8种移动方式
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //检查新位置是否在期盼内并访问过
                if (isValid(nx, ny) && !visited[nx][ny]) {
                    int g = current.g + 1; //到达新节点的实际步数
                    int h = heuristic(nx, ny, endX, endY); //启发式估值
                    pq.offer(new Node(nx, ny, g, g + h));
                }
            }
        }

        return -1; //理论上不会到达这里，因为目标时可达的
    }

    //启发函数：估计当前点到目标点的最小步数
    private static int heuristic(int x, int y, int endX, int endY) {
        int dx = Math.abs(x - endX);
        int dy = Math.abs(y - endY);
        return (dx + dy) / 3;
    }

    //检查是否在棋盘内
    private static boolean isValid(int x, int y) {
        return x >= 1 && x <= BOARD_SIZE && y >= 1 && y <= BOARD_SIZE;
    }

    //定义A*算法中的节点
    static class Node {
        int x, y, g, f;
        Node(int x, int y, int g, int f) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.f = f;
        }
    }
}
