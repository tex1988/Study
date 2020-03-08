package com.home.FileTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class FileTask3 {

    public static void fileTracer(String dirPath, File resultFileAbsolutePath) {
        File path = new File(dirPath);
        AbstractList<File> fileList = new ArrayList<>();
        String[] list = path.list();
        for (String i:list) {
            /*System.out.println(i);*/
            File tmpFile = new File(path+"\\"+i);
            if (tmpFile.isDirectory()) {
                fileTracer(tmpFile.getPath(), resultFileAbsolutePath);
            }
            else if (tmpFile.length()>100000) {
                System.out.println("File --> "+tmpFile.getAbsolutePath()+" deleted");
                tmpFile.delete();
                }
            if (tmpFile.exists() && tmpFile.isFile()) {
                fileList.add(tmpFile);
            }
        }
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File file, File t1) {
                return file.getName().compareToIgnoreCase(t1.getName());
            }
        });
        for (File i:fileList) {
            System.out.println(i.getName() + " : " + i.getAbsolutePath());
            AbstractList<Integer> byteList = new ArrayList<>();
            try {
                byte[] buffer = Files.readAllBytes((Paths.get(i.getPath())));

                FileWriter wtiter = new FileWriter(resultFileAbsolutePath, true);
                for (byte k : buffer) {
                    wtiter.write(k);
                }
                wtiter.write("\n");
                wtiter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"\\allFilesContent.txt");
        System.out.println(allFilesContent.getAbsolutePath());
        resultFileAbsolutePath.renameTo(allFilesContent);
        fileTracer(args[0], resultFileAbsolutePath);
    }
}
