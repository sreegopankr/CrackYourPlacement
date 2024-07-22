package Graph;

import java.util.*;


class Solution {
    // Directions the knight can move
    int[][] direction = {
        {1, -2}, {1, 2}, {-1, -2}, {-1, 2},
        {-2, 1}, {-2, -1}, {2, 1}, {2, -1}
    };

    // Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Base case: If the start position is the same as the target position
        if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) {
            return 0;
        }

        // Convert to 0-based indexing
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;

        // Queue to store the knight positions and their corresponding distances
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // Check all possible moves of the knight
            for (int[] dir : direction) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // If the new position is within bounds and not visited yet
                if (newX >= 0 && newY >= 0 && newX < N && newY < N && !visited[newX][newY]) {
                    // If the new position is the target position
                    if (newX == targetX && newY == targetY) {
                        return distance + 1;
                    }
                    // Mark the position as visited and add it to the queue
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, distance + 1});
                }
            }
        }

        // If the target position is not reachable, return -1 (this case should not occur given the problem constraints)
        return -1;
    }
}
