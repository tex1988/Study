package com.home;

public class IntefacesTask {


    interface Movable
    {
        public int move(int x, int y);
    }

    interface Eatable
    {
        public void eaten(Object a);
    }

    interface Eat
    {
        public void eat(Object a);
    }

    static class Dog implements Movable, Eat
    {
        String name=null;
        private int xPos=0;
        private int yPos=0;

        public int move(int x, int y)
        {
            int path = (int)Math.round(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
            return path;
        }

        public void eat(Object a)
        {
            System.out.println(name+" eat "+a.toString());
        }

        public Dog(String name)
        {
            this.name=name;
        }
    }

    static class Cat implements Movable, Eat, Eatable
    {
        String name=null;
        private int xPos=0;
        private int yPos=0;

        public int move(int x, int y)
        {
            int path = (int)Math.round(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
            return path;
        }

        public void eat(Object a)
        {
            System.out.println(name+" eat "+a.toString());
        }

        public void eaten(Object a)
        {
            System.out.println(name+" eaten by "+a.toString());
        }

        public String toString()
        {
            return this.name;
        }

        public Cat(String name)
        {
            this.name=name;
        }
    }

    static class Mouse implements Movable, Eatable
    {
        String name=null;
        private int xPos=0;
        private int yPos=0;

        public int move(int x, int y)
        {
            return (int)Math.round(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
        }

        public void eaten(Object a)
        {
            System.out.println(name+" eaten by "+a.toString());
        }

        public Mouse(String name)
        {
            this.name=name;
        }

        public String toString()
        {
            return this.name;
        }
    }


    public static void main(String[] args)
    {
        Dog dog = new Dog("Spike");
        Cat cat = new Cat("Tom");
        Mouse mouse = new Mouse("Jerry");
        int xCat=11;
        int yCat=21;
        int xMouse=20;
        int yMouse=20;
        if (mouse.move(xMouse,yMouse)<cat.move(xCat,yCat))
        {
            cat.eat(mouse);
            mouse.eaten(cat);
        }
        System.out.println("Jerry ran away");
    }
}
