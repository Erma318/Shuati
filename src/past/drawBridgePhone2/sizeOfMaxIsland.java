package past.drawBridgePhone2;

public class sizeOfMaxIsland {
    public int numIslands(char[][] grid) {
        int res = 0;
        int[] size = new int[1];
        int[] per = new int[1];
        char[][] g = new char[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                g[i][j] = grid[i][j];
            }
        }
        int maxSize = Integer.MIN_VALUE;
        int maxpre = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    per[0] = 0;
                    bfs(grid, i, j, size, per, g);
                    //maxSize = Math.max(maxSize, size[0]);
                    maxpre = Math.max(maxpre, per[0]);
                    res++;
                }
            }
        }
        return maxpre;
    }

    private void bfs(char[][] grid, int i, int j, int[] size, int[] per, char[][] g) {
        if  (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1') {
            int num = checkNeighbourNum(g, i, j);
            size[0] += 1;
            grid[i][j] = '0';
            per[0] += 4 - num;
            bfs(grid, i + 1, j, size, per, g);
            bfs(grid, i, j + 1, size, per, g);
            bfs(grid, i - 1, j, size, per, g);
            bfs(grid, i, j - 1, size, per, g);
        }
    }

    private int checkNeighbourNum(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        if (i > 0 && grid[i - 1][j] == '1') {
            count++;
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            count++;
        }
        if (i < n - 1  && grid[i + 1][j] == '1') {
            count++;
        }
        if (j < m - 1 && grid[i][j + 1] == '1') {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] test = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        sizeOfMaxIsland here = new sizeOfMaxIsland();
        System.out.println(here.numIslands(test));
    }
}
