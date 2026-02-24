package org.example;

public class Event {
    private String name;
    private int month;
    private int day;
    private String startTime;

    Event(String Name, int Month, int Day, String StartTime) {
        name = Name;
        month = Month;
        day = Day;
        startTime = StartTime;
    }

    public String toString() {
        return "\"" + name + "\" on " + month + "/" + day + " at " + startTime;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void reschedule(int month, int day) {
        this.month = month;
        this.day = day;
    }
}

// I thought I was going to use this but I didn't :/
// String[] monthName = {
// "January",
// "February",
// "March",
// "April",
// "May",
// "June",
// "July",
// "August",
// "September",
// "October",
// "November",
// "December"
// };
