package com.home.InnerClassTask.AnonymousClassTask2;

import com.home.InnerClassTask.AnonymousClassTask2.vo.*;

import java.lang.reflect.Method;
import java.util.List;

public class AnonymousClassTask2 {

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public static List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "select * from USER";
            }
        }.execute();
    }

    public static List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "select * from Location";
            }
        }.execute();
    }

    public static List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return "select * from Server";
            }
        }.execute();
    }

    public static List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "select * from Subject";
            }
        }.execute();
    }

    public static List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "select * from Subscription";
            }
        }.execute();
    }

    public static void main(String[] args) {
        AnonymousClassTask2 anonymousClassTask2 = new AnonymousClassTask2();
        print(AnonymousClassTask2.getUsers());
        print(AnonymousClassTask2.getLocations());
        print(AnonymousClassTask2.getServers());
        print(AnonymousClassTask2.getSubjects());
        print(AnonymousClassTask2.getSubscriptions());
        for(Method i:anonymousClassTask2.getClass().getMethods()) {
            System.out.println(i.toString());
        }
    }
}
