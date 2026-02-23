package org.example;

public class Event {
    private String name;
    private int month;
    private int day;

    Event(String Name, int Month, int Day) {
        name = Name;
        month = Month;
        day = Day;
    }

    public String toString() {
        return "\"" + name + "\" on " + month + "/" + day;
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
