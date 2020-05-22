package com.livtech.demo.datastructure.backtracking;

public class RateNMaze {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        solveMaze(maze, maze.length, maze[0].length);
    }

    public static boolean canMove(int x, int y, int[][] maze, int[][] sol, int M, int N) {
        if (x == M - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        if (x >= 0 && x < M && y >= 0 && y < N && maze[x][y] == 1) {
            sol[x][y] = 1;
            if (canMove(x, y + 1, maze, sol, M, N))
                return true;
            if (canMove(x + 1, y, maze, sol, M, N))
                return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void solveMaze(int[][] maze, int M, int N) {
        int[][] sol = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                sol[i][j] = 0;
        }
        if (canMove(0, 0, maze, sol, M, N)) {
            System.out.println("Can reach to destination");
            print(sol);
        } else {
            System.out.println("Can not reach to destination");
        }
    }

    static void print(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            System.out.println();
            for (int j = 0; j < sol[i].length; j++) {
                System.out.print(sol[i][j] + " ");
            }
        }
    }
}
