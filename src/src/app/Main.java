package app;

import gui.GUIFactory;
import gui.MacOSFactory;
import gui.WindowsFactory;
import logistics.Logistics;
import logistics.RoadLogistics;
import logistics.SeaLogistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter delivery mode (ROAD / SEA): ");
        if (!cs.hasNextLine()) {
            System.err.println("Error: No input stream available.");
            System.exit(1);
        }
        String mode = cs.nextLine().trim().toUpperCase();

        System.out.println("Enter UI platform (WINDOWS / MACOS)");
        if (!cs.hasNextLine()) {
                System.err.println("Error: No input stream available.");
                System.exit(1);
        }
        String platform = cs.nextLine().trim().toUpperCase();

        Logistics logistics;
        if (mode.equals("ROAD")){
            logistics = new RoadLogistics();
        } else if (mode.equals("SEA")) {
            logistics = new SeaLogistics();
        } else {
            System.err.println("Error: Invalid delivery mode: " + mode);
            System.exit(1);
            return;
        }

        GUIFactory guiFactory;
        if (platform.equals("WINDOWS")){
            guiFactory = new WindowsFactory();
        } else if (platform.equals("MACOS")) {
            guiFactory = new MacOSFactory();
        } else {
            System.err.println("Error: Invalid UI platform: "+ platform);
            System.exit(1);
            return;
        }

        DeliveryApplication application = new DeliveryApplication(guiFactory, logistics);
        application.run("laboratory equipment", "Aktau warehouse");

    }
}
