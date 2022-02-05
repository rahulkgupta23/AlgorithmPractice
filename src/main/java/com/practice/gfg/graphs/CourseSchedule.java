package com.practice.gfg.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * Find Cycle in a Directed Graph
 *  1. WhiteSet - contains vertices which haven't been visited yet
 *  2. GraySet - Vertices which are being worked upon(along with their children)
 *  3. BlackSet - Vertices which have been visited along with their children
 */
public class CourseSchedule {

    List<Integer>[] adjacencyList;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean result = true;

        adjacencyList = new ArrayList[numCourses];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            adjacencyList[prerequisite[1]].add(prerequisite[0]);
        }

        Set<Integer> whiteSet = new HashSet<>();
        Set<Integer> graySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            whiteSet.add(i);
        }

        while (!whiteSet.isEmpty()) {
            //if true is returned that means cycle exists and we can't finish
            if (dfs(whiteSet.iterator().next(), whiteSet, graySet, blackSet))
                return false;
        }
        return true;
    }

    //Detectes a cycle in Direct Graph and returns true in case it finds it
    public boolean dfs(int vertex, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet) {
        moveVertex(vertex, whiteSet, graySet);

        for (int neighbours : adjacencyList[vertex]) {
            if (blackSet.contains(neighbours))
                continue;

            if (graySet.contains(neighbours))
                return true;

            if(dfs(neighbours, whiteSet, graySet, blackSet))
                return true;
        }
        moveVertex(vertex,graySet, blackSet);
        return false;
    }

    public void moveVertex(int vertex, Set<Integer> sourceSet, Set<Integer> destSet) {
        sourceSet.remove(vertex);
        destSet.add(vertex);
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(2, new int[][] {{1, 0}}));
        System.out.println(courseSchedule.canFinish(2, new int[][] {{0, 1}}));
        System.out.println(courseSchedule.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
        System.out.println(courseSchedule.canFinish(20, new int[][] {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
    }
}
