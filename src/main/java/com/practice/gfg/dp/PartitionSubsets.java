package com.practice.gfg.dp;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/partition-into-subsets-official/ojquestion
 */
public class PartitionSubsets {
    static int findNofWays(int persons, int teams) {
        int[][] ways = new int[teams + 1][persons + 1];

        for (int team = 1; team <= teams; team++) {
            for (int person = 1; person <= persons; person++) {
                if (team == 1)
                    ways[team][person] = 1;
                else if (person < team)
                    ways[team][person] = 0;
                else if (team == person)
                    ways[team][person] = 1;
                else
                    ways[team][person] = ways[team][person - 1] * team + ways[team - 1][person - 1];
            }
        }

        for (int i = 0; i <= teams; i++) {
            for (int j = 0; j <= persons; j++) {
                System.out.print(ways[i][j] + "\t");
            }
            System.out.println(" ");
        }
        return ways[teams][persons];
    }

    public static void main(String[] args) {
        System.out.println(findNofWays(5, 4));
    }
}
