package past.bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class findCar {
    static class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int find(int[][] matrix, int x, int y) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
//        System.out.println(m);
//        System.out.println(n);
        int[][] visited = new int[m][n];
        Queue<Cell> queue = new LinkedList<>();
        int res = 0;
        queue.offer(new Cell(x, y));
        Cell[] d = {
                new Cell(1,0),
                new Cell(-1,0),
                new Cell(0,1),
                new Cell(0,-1)
        };
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Cell cur = queue.poll();
                visited[cur.x][cur.y] = 1;
                for (int j = 0; j < 4; j++) {
                    if (0 <= cur.x + d[j].x && cur.x + d[j].x < m && 0 <= cur.y + d[j].y && cur.y + d[j].y < n) {
                        if (visited[cur.x + d[j].x][cur.y + d[j].y] != 1) {
                            if (matrix[cur.x + d[j].x][cur.y + d[j].y] == 1) {
                                return count;
                            } else {
                                queue.add(new Cell(cur.x + d[j].x, cur.y + d[j].y));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] m = {
                {0,1,0,0},
                {0,0,0,0},
                {0,1,0,0}
        };
        findCar here = new findCar();
        System.out.print(here.find(m, 1,3));
    }
}
