package com.home;

public class CloneTask2 {

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Plant clone() throws CloneNotSupportedException
        {
            return new Plant (this.getName());
        }
    }


    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException {
            if (this.getBranches()!=null) {
                return new Tree(this.getName(), this.getBranches().clone());
            }
            else return new Tree(this.getName(), null);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
        for (String i:clone.branches) {
            System.out.println(i);
        }
    }

}
