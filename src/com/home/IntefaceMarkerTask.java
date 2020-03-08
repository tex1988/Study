package com.home;

import java.lang.reflect.Method;

public class IntefaceMarkerTask {

    public interface SelfInterfaceMarker {}

    public static class UnsupportedInterfaceMarkerException extends Exception {
    }

    public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker{
        public void print() {}
        public void step() {}
        public SelfInterfaceMarkerImpl() {}

    }

    public static class Util {
        public static void testClass(SelfInterfaceMarker interfaceMarker) throws UnsupportedInterfaceMarkerException {
            if (interfaceMarker==null) throw new UnsupportedInterfaceMarkerException();
            for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
                System.out.print(method);
            }
        }
    }

    public static void main(String[] args) {

    }
}
