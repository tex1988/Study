package com.home.StreamTasks.AdapterTask;


import java.util.HashMap;
import java.util.Map;

public class AdapterTask5 {

    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryCode="";
            for (Map.Entry<String, String> i:countries.entrySet()) {
                if (i.getValue().equals(customer.getCountryName())) {
                    countryCode=i.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().substring(contact.getName().indexOf(" ")+1, contact.getName().length());
        }

        @Override
        public String getContactLastName() {
            return contact.getName().substring(0, contact.getName().indexOf(","));
        }

        @Override
        public String getDialString() {
            String phoneNumber=contact.getPhoneNumber();
            return phoneNumber.substring(0, 3)+phoneNumber.substring(4, 7)+phoneNumber.substring(8, 11)+phoneNumber.substring(12, 14)+phoneNumber.substring(15, 17);
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };

        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };

        DataAdapter adapter = new DataAdapter(customer, contact);
        System.out.println(adapter.getContactFirstName());
        System.out.println(adapter.getContactLastName());
        System.out.println(adapter.getDialString());
        System.out.println(adapter.getCountryCode());
        System.out.println(adapter.getCompany());
    }
}
