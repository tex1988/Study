package com.home.FileTask;

import java.io.*;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.*;

public class ZipTask1 {
    public static void main(String[] args) throws IOException{
        LinkedHashMap<ZipEntry, byte[]> zipEntryMap = new LinkedHashMap<>();
        ZipFile zip = new ZipFile(args[1]);
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]));
        ZipEntry entry;

        while ((entry=zipIn.getNextEntry())!=null) {
            byte[] buffer = new byte[(int)entry.getSize()];
            InputStream stream = zip.getInputStream(entry);
            while (stream.available()>0) {
                stream.read(buffer);
            }
            zipEntryMap.put(entry, buffer);
            zipIn.closeEntry();
        }
        zipIn.close();

        File file = new File(args[0]);
        for (Map.Entry<ZipEntry, byte[]> mapentry:zipEntryMap.entrySet()){
            if (mapentry.getKey().getName().equals(file.getName())) {
                entry=mapentry.getKey();
                break;
            }
        }
        zipEntryMap.remove(entry);

        byte[] buffer = Files.readAllBytes(file.toPath());
        zipEntryMap.put(new ZipEntry(file.getName()), buffer);

        FileOutputStream fileOut = new FileOutputStream(args[1]);
        ZipOutputStream zipOut = new ZipOutputStream(fileOut);
        for (Map.Entry<ZipEntry, byte[]> mapentry:zipEntryMap.entrySet()){
            zipOut.putNextEntry(new ZipEntry(mapentry.getKey().getName()));
            zipOut.write(mapentry.getValue());
            zipOut.closeEntry();
        }
        zipOut.close();
    }
}
