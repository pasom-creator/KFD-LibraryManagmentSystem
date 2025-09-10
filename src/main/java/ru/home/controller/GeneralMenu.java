package ru.home.controller;

import java.util.HashMap;
import java.util.Map;

public abstract class GeneralMenu {
    protected final Map<String,Runnable> GENERAL_MAP;

    public GeneralMenu() {
        this.GENERAL_MAP = new HashMap<>();
    }

}
