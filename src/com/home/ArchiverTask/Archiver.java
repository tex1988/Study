package com.home.ArchiverTask;

import com.home.ArchiverTask.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        System.out.println("Введите полный путь к архиву:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(reader.readLine()));
            System.out.println("Введите полный путь к файлу:");
            zipFileManager.createZip(Paths.get(reader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExitCommand exitCommand = new ExitCommand();
        try {
            exitCommand.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
