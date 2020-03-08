package com.home;

public class PegasusTask {

    interface fly
    {
        void fly(int x, int y, int z);
    }

    static class Horse
    {
        private int xPos=0;
        private int yPos=0;

        public void run(int x, int y)
        {
            xPos=xPos+x;
            yPos=yPos+y;
            System.out.println("Я пробежал "+(int)Math.round(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)))+" м");
        }
    }

    public static class Pegasus extends Horse implements fly
    {
        private int zPos=0;

        public void fly(int x, int y, int z)
        {
            if (z<0) System.out.println("Не могу летать под землей");
            super.xPos=super.xPos+x;
            super.yPos=super.yPos+y;
            zPos=zPos+z;
            System.out.println("Я пролетел "+(int)Math.round(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)))+" м на высоте "+zPos+" м");
        }
    }

public  static  void main(String[] args)
{
    Horse horse = new Horse();
    horse.run(1, 2);
    Pegasus pegasus = new Pegasus();
    pegasus.fly(1,2,3);
}

}
