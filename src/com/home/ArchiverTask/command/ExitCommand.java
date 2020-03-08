package com.home.ArchiverTask.command;

import com.home.ChatTask.ConsoleHelper;

import java.io.IOException;

public class ExitCommand implements Command {
    @Override
    public void execute() throws IOException {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
