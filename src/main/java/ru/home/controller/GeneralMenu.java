package ru.home.controller;

import java.util.HashMap;
import java.util.Map;

import static ru.home.controller.ConsoleReader.askQuestion;

public abstract class GeneralMenu {
    protected final Map<String,Runnable> GENERAL_MAP;
    protected final String options;

    public GeneralMenu(String options) {
        this.GENERAL_MAP = new HashMap<>();
        this.options = options;
    }

    public void start() {
        Runnable runnable = null;
        while(true) {
            try {
                runnable = GENERAL_MAP.get(askQuestion(options));
                break;
            } catch (NullPointerException e) {
                System.out.println("Wrong option selected");
            }
        }
        runnable.run();
        start();
    }

}
