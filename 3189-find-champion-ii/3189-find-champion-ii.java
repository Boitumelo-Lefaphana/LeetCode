import java.util.*;

class Solution {
    public int findChampion(int n, int[][] edges) {
        // Step 1: Calculate in-degrees for all nodes
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++; // Increment in-degree for the destination node
        }

        // Step 2: Identify nodes with zero in-degree
        int champion = -1; // To store the potential champion
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (champion == -1) {
                    champion = i; // First node with zero in-degree
                } else {
                    // More than one node with zero in-degree
                    return -1;
                }
            }
        }

        // Step 3: Return the champion if valid, otherwise -1
        return champion;
    }
}
