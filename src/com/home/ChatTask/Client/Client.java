package com.home.ChatTask.Client;

import com.home.ChatTask.Connection;
import com.home.ChatTask.ConsoleHelper;
import com.home.ChatTask.Message;
import com.home.ChatTask.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAdress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователся:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка во время отправки сообщения");
            clientConnected=false;
        }
    }

    public void run () {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Критическая ошибка");
            return;
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено");
            String text;
            while (!(text=ConsoleHelper.readString()).equals("exit")) {
                if (shouldSentTextFromConsole()) {
                    sendTextMessage(text);
                }
                else {return;}
            }
        }
        else {ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента");}

    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName+" присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName+" покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        private void clientHandshake() throws IOException {
            while (true) {
                Message receivedMessage = null;
                try {
                    receivedMessage = connection.receive();
                } catch (ClassNotFoundException e) {System.out.println("Class not found");}
                if (receivedMessage.getType()==MessageType.NAME_REQUEST) {
                    Message sentMessage = new Message(MessageType.USER_NAME, getUserName());
                    connection.send(sentMessage);
                }
                else if (receivedMessage.getType()==MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException {
            while (true) {
                Message receivedMessage = null;
                try {
                    receivedMessage = connection.receive();
                } catch (ClassNotFoundException e) {System.out.println("Unexpected MessageType");}
                if (receivedMessage.getType()==MessageType.TEXT) {
                    processIncomingMessage(receivedMessage.getData());
                }
                else if (receivedMessage.getType()==MessageType.USER_ADDED) {
                    informAboutAddingNewUser(receivedMessage.getData());
                }
                else if (receivedMessage.getType()==MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(receivedMessage.getData());
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run() {
            try {
                Socket socket = new Socket(getServerAdress(), getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {notifyConnectionStatusChanged(false);}
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
