package com.home.StreamTasks.AdapterTask;

import java.util.HashMap;
import java.util.Map;

public class AdapterTask3 {

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static Map<String,String> countries = new HashMap<String,String>();
    static  {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getName() {
            return incomeData.getContactLastName()+", "+incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {

            return "+"+incomeData.getCountryPhoneCode()+"("+
                    Integer.toString(incomeData.getPhoneNumber()).substring(0,2)+")"+
                    Integer.toString(incomeData.getPhoneNumber()).substring(2,5)+"-"+
                    Integer.toString(incomeData.getPhoneNumber()).substring(5,7)+"-"+
                    Integer.toString(incomeData.getPhoneNumber()).substring(7,Integer.toString(incomeData.getPhoneNumber()).length());
        }

        @Override
        public String getCompanyName() {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(incomeData.getCountryCode());
        }
    }

    public static void main(String[] args) {

        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };

        IncomeDataAdapter adapter = new IncomeDataAdapter(incomeData);
        System.out.println(adapter.getPhoneNumber());
        System.out.println(adapter.getCountryName());
        System.out.println(adapter.getName());
        System.out.println(adapter.getCompanyName());

    }

}
