package org.example;

import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Planner {
    private ArrayList[][] date = {
            new ArrayList[31],
            new ArrayList[28],
            new ArrayList[31],
            new ArrayList[30],
            new ArrayList[31],
            new ArrayList[30],
            new ArrayList[31],
            new ArrayList[31],
            new ArrayList[30],
            new ArrayList[31],
            new ArrayList[30],
            new ArrayList[31],
    };

    private ArrayList<Event> allEvents = new ArrayList<>();

    public void addEvent(Event event) {
        System.out.println("Adding Event");
        int month = event.getMonth() - 1;
        int day = event.getDay() - 1;
        if (date[month][day] == null) {
            date[month][day] = new ArrayList<Event>();
        }
        date[month][day].add(event);
        allEvents.add(event);
    }

    public ArrayList<Event> getAllEvents() {
        return allEvents;
    }

    public ArrayList<Event> getEventsForDay(int month, int day) {
        return date[month - 1][day - 1];
    }

}
