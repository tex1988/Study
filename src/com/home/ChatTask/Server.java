package com.home.ChatTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType()== MessageType.USER_NAME) {
                    if (message.getData()!=null && !message.getData().isEmpty()) {
                        if (!connectionMap.containsKey(message.getData())) {
                            connectionMap.put(message.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers (Connection connection, String userName) throws IOException {
            for (String name:connectionMap.keySet()) {
                if (!name.equals(userName)) {connection.send(new Message(MessageType.USER_ADDED, name));}
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType()==MessageType.TEXT) {
                    Message newMessage = new Message(MessageType.TEXT, userName+": "+message.getData());
                    sendBroadcast(newMessage);
                }
                else {ConsoleHelper.writeMessage("Сообщение не является текстом");}
            }
        }

        @Override
        public void run() {
            String clientName = null;
            try (Connection connection = new Connection(socket)) {
                ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом " + connection.getSocket().getRemoteSocketAddress());
                clientName = serverHandshake(connection);
                sendBroadcast(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);
            } catch (IOException e) {ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");}
            connectionMap.remove(clientName);
            sendBroadcast(new Message(MessageType.USER_REMOVED, clientName));
            ConsoleHelper.writeMessage("Cоединение с удаленным адресом "+socket.getRemoteSocketAddress()+" закрыто");
        }
    }

    public static void sendBroadcast(Message message) {
        try {
            for (Connection connection:connectionMap.values()) {
                connection.send(message);
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Не удалось отправить сообщение");
        }
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошиюка сокета "+e);
        }
    }
}
