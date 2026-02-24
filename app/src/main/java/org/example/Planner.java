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

    public boolean rescheduleEvent(Event event, int newMonth, int newDay) {
        int oldMonth = event.getMonth() - 1;
        int oldDay = event.getDay() - 1;
        ArrayList<Event> oldDateEvents = date[oldMonth][oldDay];
      if (oldDateEvents == null || !oldDateEvents.remove(event)) {
          return false;
      }

       if (oldDateEvents.isEmpty()) {
           date[oldMonth][oldDay] = null;
        }

        event.reschedule(newMonth, newDay);

        int targetMonth = newMonth - 1;
        int targetDay = newDay - 1;
        if (date[targetMonth][targetDay] == null) {
            date[targetMonth][targetDay] = new ArrayList<Event>();
        }

        date[targetMonth][targetDay].add(event);
        return true;
    }
}