package com.home;

public class animals {

    interface fly
    {
        void fly(int x, int y, int z);
    }

    interface run
    {
        void run(int x, int y);
    }

    interface swim
    {
        void swim(int x, int y, int z);
    }

    static class Cow implements run
    {
        private int xPos=0;
        private int yPos=0;
        public void printColor()
        {
            System.out.println("Я - белая");
        }
        public void printName()
        {
            System.out.println("Я - корова");
        }

        public void run(int x, int y)
        {
            xPos=xPos+x;
            yPos=yPos+y;
        }
    }

    static class Whale extends Cow implements swim
    {
        private int xPos=0;
        private int yPos=0;
        private int zPos=0;
        public void printName()
        {

        }

        public void swim (int x, int y, int z)
        {
            if (z>0)
            {
                System.out.println("Нельзя нырять вверх");
            }
            xPos=xPos+x;
            yPos=yPos+y;
            zPos=zPos+z;
            int path = (int)Math.round(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
            System.out.println("Я проплыл "+path+" м и нырнул на глубину "+Math.abs(z)+" м");
        }
    }
    static class Dog extends Animal implements run, swim
    {
        private int xPos=0;
        private int yPos=0;
        private int zPos=0;

        public  void getName()
        {
            System.out.print("Собака");
        }

        public void swim (int x, int y, int z)
        {
            if (z>0)
            {
                System.out.println("Нельзя нырять вверх");
            }
            xPos=xPos+x;
            yPos=yPos+y;
            zPos=zPos+z;

            int path = (int)Math.round(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
            System.out.println("Я проплыл "+path+" м и нырнул на глубину "+Math.abs(z)+" м");
        }

        public void run(int x, int y)
        {
            xPos=xPos+x;
            yPos=yPos+y;
        }

        public Dog(int x, int y, int z)
        {
            xPos=xPos+x;
            yPos=yPos+y;
            zPos=zPos+z;
        }
    }

    abstract static class Animal implements run
    {
        abstract public void getName();
    }

    static void getClass(Object object)
    {
        if (object instanceof Whale){System.out.println("Кит");}
        else if (object instanceof Cow){System.out.println("Корова");}
        else {System.out.println("Неизвестное животное");}
    }

    static void print (String a)
    {
        System.out.println(a);
    }

    static void print (int a)
    {
        System.out.println(a);
    }

    static void print (Integer a)
    {
        System.out.println(a);
    }

    static void print (Double a)
    {
        System.out.println(a);
    }
    static void compare (Double a, Double b)
    {
        if (a<b) {
            System.out.println(a);
        }
    }

    static void compare (int a, int b)
    {
        if (a<b) {
            System.out.println(a);
        }
    }

    public static void main(String[] args)
    {
        Whale whale = new Whale();
        getClass(whale);
        Dog dog = new Dog(3, 1, 0);
        getClass(dog);

        String a="dfdff";
        int b = 1245648;
        Integer c = 55758454;
        print(a);
        print(b);
        print(c);
        Double e = 3.225556;
        print(e);
        compare(b,c);

        whale.swim(3,2,-3);

        dog.run(3, 4);
        dog.swim(3,5,-1);
    }

}
