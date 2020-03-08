package com.home.StreamTasks;

import java.util.List;

public class StreamTask7 {

    public interface ATableInterface {

        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static class TableInterfaceWrapper implements ATableInterface {

        private ATableInterface boob;

        public TableInterfaceWrapper(ATableInterface tableInterface) {
            this.boob=tableInterface;
        }

        @Override
        public String getHeaderText() {
            return boob.getHeaderText().toUpperCase();
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            boob.setModel(rows);
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            boob.setHeaderText(newHeaderText);
        }
    }
}
