package com.home.ChatTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() {
        String command;
        try {
            command = reader.readLine();
        } catch (IOException e) {
            command="Произошла ошибка при попытке ввода текста. Попробуйте еще раз";
        }
        return command;
    }

    public static int readInt() {
        int digit;

        while (true) {
            try {
                digit = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа");
            }
        }
        return digit;
    }
}
