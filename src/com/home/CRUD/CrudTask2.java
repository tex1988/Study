package com.home.CRUD;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;


public class CrudTask2 {

    public static void main(String[] args) throws IOException{

        String newline = System.getProperty("line.separator");

        if (args[0].equals("c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File file = new File("C:/Users/Tex88/Desktop/" + reader.readLine() + ".txt");
            file.createNewFile();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String fileLine;
            Integer id = 0;

            while ((fileLine = fileReader.readLine()) != null) {
                String tmpId = fileLine.substring(0, 8);
                if (id <= Integer.parseInt(tmpId.trim())) {
                    id = Integer.parseInt(tmpId.trim()) + 1;
                }
            }
            fileReader.close();
            reader.close();
            if (id.toString().length() < 8) {
                sb.append(id.toString());
                for (int i = 0; i < 8 - id.toString().length(); i++) {
                    sb.append(" ");
                }
            } else {
                sb.append(id.toString());
            }

            if (args[1].length() < 30) {
                sb.append(args[1]);
                for (int i = 0; i < 30 - args[1].length(); i++) {
                    sb.append(" ");
                }
            } else if (args[1].length() > 30) {
                sb.append(args[1].substring(0, 30));
            } else {
                sb.append(args[1]);
            }

            if (args[2].length() < 8) {
                sb.append(args[2]);
                for (int i = 0; i < 8 - args[2].length(); i++) {
                    sb.append(" ");
                }
            } else {
                sb.append(args[2]);
            }

            if (args[3].length() > 4) {
                sb.append(args[3].substring(0, 4));
            } else {
                sb.append(args[3]);
            }

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));
            fileWriter.write(sb.toString() + newline);
            fileWriter.close();
        }

        else if (args[0].equals("u")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File file = new File("C:/Users/Tex88/Desktop/" + reader.readLine() + ".txt");
            reader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            StringBuilder idSb = new StringBuilder();
            String fileLine;
            LinkedHashMap<String, String> lineMap = new LinkedHashMap<>();

            while ((fileLine=fileReader.readLine())!=null){
                lineMap.put(fileLine.substring(0,8), fileLine.substring(8, fileLine.length()));
            }
            fileReader.close();

            if (args[1].length()<8) {
                idSb.append(args[1]);
                for (int i=0; i<8-args[1].length(); i++) {
                    idSb.append(" ");
                }
            }
            else {idSb.append(args[2]);}

            if (args[2].length() < 30) {
                sb.append(args[2]);
                for (int i = 0; i < 30 - args[2].length(); i++) {
                    sb.append(" ");
                }
            } else if (args[2].length() > 30) {
                sb.append(args[2].substring(0, 30));
            } else {
                sb.append(args[2]);
            }

            if (args[3].length() < 8) {
                sb.append(args[3]);
                for (int i = 0; i < 8 - args[3].length(); i++) {
                    sb.append(" ");
                }
            } else {
                sb.append(args[3]);
            }

            if (args[4].length() < 4) {
                sb.append(args[4]);
                for (int i = 0; i < 4 - args[4].length(); i++) {
                    sb.append(" ");
                }
            } else if (args[4].length() > 4) {
                sb.append(args[4].substring(0, 5));
            } else {
                sb.append(args[4]);
            }

            for (Map.Entry<String, String> i:lineMap.entrySet()) {
                if (i.getKey().equals(idSb.toString())) {
                    lineMap.put(i.getKey(), sb.toString());
                }
            }

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> i:lineMap.entrySet()) {
                fileWriter.write(i.getKey()+i.getValue()+newline);
            }
            fileWriter.close();
        }

        else if (args[0].equals("d")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File file = new File("C:/Users/Tex88/Desktop/" + reader.readLine() + ".txt");
            reader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            StringBuilder idSb = new StringBuilder();
            String fileLine;
            LinkedHashMap<String, String> lineMap = new LinkedHashMap<>();

            while ((fileLine=fileReader.readLine())!=null){
                lineMap.put(fileLine.substring(0,8), fileLine.substring(8, fileLine.length()));
            }
            fileReader.close();

            if (args[1].length()<8) {
                idSb.append(args[1]);
                for (int i=0; i<8-args[1].length(); i++) {
                    idSb.append(" ");
                }
            }
            else {idSb.append(args[2]);}

            Map<String, String> editedLineMap = new LinkedHashMap<>(lineMap);
            for (Map.Entry<String, String> i:lineMap.entrySet()) {
                if (i.getKey().equals(idSb.toString())) {
                    editedLineMap.remove(i.getKey());
                }
            }

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> i:editedLineMap.entrySet()) {
                fileWriter.write(i.getKey()+i.getValue()+newline);
            }
            fileWriter.close();
        }
    }
}
