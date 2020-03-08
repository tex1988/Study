package com.home.SerializationTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Human {
    public String name;
    public List<Asset> assets = new ArrayList<>();

    public Human() {
    }

    public Human(String name, Asset... assets) {
        this.name = name;
        if (assets != null) {
            this.assets.addAll(Arrays.asList(assets));
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(name);
        for (Asset i:assets) {
            writer.println(i.getName());
            writer.println(Double.toString(i.getPrice()));
        }
        writer.flush();
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        name = reader.readLine();
        String assetName;
        String assetPrice;
        int assetCounter=0;
        while ((assetName=reader.readLine())!=null && (assetPrice=reader.readLine())!=null) {
            assets.add(new Asset(assetName));
            assets.get(assetCounter).setPrice(Double.parseDouble(assetPrice));
            assetCounter++;
        }
        reader.close();
    }
}
