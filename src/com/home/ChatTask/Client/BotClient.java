package com.home.ChatTask.Client;

import com.home.ChatTask.Connection;
import com.home.ChatTask.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            String[] separatedMessage = message.split(": ");
            String messageText = separatedMessage[1];
            String name = separatedMessage[0];
            Date date = new Date();
            if (messageText.equals("дата")) {
                DateFormat dateFormat = new SimpleDateFormat("d.MM.YYYY");
                sendTextMessage("Информация для "+name+": "+dateFormat.format(date));
            }
            else if (messageText.equals("день")) {
                DateFormat dateFormat = new SimpleDateFormat("d");
                sendTextMessage("Информация для "+name+": "+dateFormat.format(date));
            }
            else if (messageText.equals("месяц")) {
                DateFormat dateFormat = new SimpleDateFormat("MMMM");
                sendTextMessage("Информация для "+name+": "+dateFormat.format(date));
            }
            else if (messageText.equals("год")) {
                DateFormat dateFormat = new SimpleDateFormat("YYYY");
                sendTextMessage("Информация для "+name+": "+dateFormat.format(date));
            }
            else if (messageText.equals("время")) {
                DateFormat dateFormat = new SimpleDateFormat("H:mm:ss");
                sendTextMessage("Информация для "+name+": "+dateFormat.format(date));
            }
            else if (messageText.equals("час")) {
                DateFormat dateFormat = new SimpleDateFormat("H");
                sendTextMessage("Информация для "+name+": "+dateFormat.format(date));
            }
            else if (messageText.equals("минуты")) {
                DateFormat dateFormat = new SimpleDateFormat("m");
                sendTextMessage("Информация для "+name+": "+dateFormat.format(date));
            }
            else if (messageText.equals("секунды")) {
                DateFormat dateFormat = new SimpleDateFormat("s");
                sendTextMessage("Информация для "+name+": "+dateFormat.format(date));
            }
        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_"+Math.round(Math.random()*100);
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }


    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
