package employees;

import logging.LoggerConfig;
import runner.Runner;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = LoggerConfig.configure(App.class.getName());
    public static void main(String[] args) {
        Runner.run();
    }
}