package org.example;

public class Main {
    public static void main(String[] args) {
        while (true) {
            UserInterface userInterface = new UserInterface();
            userInterface.init();
            userInterface.display();
        }
    }
}