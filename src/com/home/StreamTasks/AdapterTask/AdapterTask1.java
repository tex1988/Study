package com.home.StreamTasks.AdapterTask;

public class AdapterTask1 {

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }

    public static class TableAdapter implements BTable{

        private ATable aTable;

        public TableAdapter(ATable aTable) {
            this.aTable = aTable;
        }

        @Override
        public String getHeaderText() {
            return "["+aTable.getCurrentUserName()+"]: "+aTable.getTableName();
        }
    }

    public static void main(String[] args) {

        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable bTable = new TableAdapter(aTable);
        System.out.println(bTable.getHeaderText());

    }

}


