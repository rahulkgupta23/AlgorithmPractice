package com.practice;

import java.util.*;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> roomsToProcess = new Stack<>();
        boolean[] roomsProcessed = new boolean[rooms.size()];

        roomsToProcess.push(0);

        while (!roomsToProcess.isEmpty()) {
            Integer processingRoom = roomsToProcess.pop();
            List<Integer> listOfRooms = rooms.get(processingRoom);
            roomsProcessed[processingRoom] = true;

            for (Integer room : listOfRooms) {
                if (!roomsProcessed[room]) {
                    roomsProcessed[room] = true;
                    roomsToProcess.push(room);
                }
            }
        }

        for (boolean bool : roomsProcessed) {
            if (!bool)
                return bool;
        }

        return true;
    }
}