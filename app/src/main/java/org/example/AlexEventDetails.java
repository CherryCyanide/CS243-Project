package org.example;

import java.io.*;

public class AlexEventDetails {

    private static final String FILE_NAME = "alex_event.txt";

    public static void run() {
        System.out.println("\n=== Alex Feature: Event Location + Description ===");

        Event event = loadEvent();

        if (event == null) {
            System.out.println("No saved event found. Creating a new one.");
            event = new Event(
                "Sample Event",
                "Bellevue, WA",
                "Meet mentor and discuss career path"
            );
        } else {
            System.out.println("Loaded saved event:");
        }

        displayEvent(event);

        // Simulate editing
        event.location = "Seattle, WA";
        event.description = "Updated notes after rescheduling";

        saveEvent(event);

        System.out.println("\nUpdated and saved event:");
        displayEvent(event);
    }

    private static void displayEvent(Event e) {
        System.out.println("Title: " + e.title);
        System.out.println("Location: " + e.location);
        System.out.println("Description: " + e.description);
    }

    private static Event loadEvent() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String title = br.readLine();
            String location = br.readLine();
            String description = br.readLine();
            return new Event(title, location, description);
        } catch (IOException e) {
            return null;
        }
    }

    private static void saveEvent(Event e) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            out.println(e.title);
            out.println(e.location);
            out.println(e.description);
        } catch (IOException ignored) {}
    }

    private static class Event {
        String title;
        String location;
        String description;

        Event(String title, String location, String description) {
            this.title = title;
            this.location = location;
            this.description = description;
        }
    }
}
