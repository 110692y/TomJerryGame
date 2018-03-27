public class Solution {
    public static void main(String[] args) {
        Dog spike = new Dog();
        Cat tom = new Cat();
        Mouse jerry = new Mouse();
        spike.geoposition = 50;
        tom.geoposition = 50;
        jerry.geoposition = 100;

        tom.move(-6);
        tom.move(6);
        System.out.println("tom.geoposition: " + tom.geoposition);
        System.out.println("spike.geoposition: " + spike.geoposition);

        if (tom.geoposition == jerry.geoposition) {
            jerry.status = false;
            tom.hungry = true;
            System.out.println("Is Jerry alive? " + jerry.status + ". Is Tom hungry? " + tom.hungry);
        } else {
            jerry.status = true;
            tom.hungry = false;
            System.out.println("Is Jerry alive? " + jerry.status + ". Is Tom hungry? " + tom.hungry);
        }

        if (spike.geoposition == tom.geoposition) {
            tom.status = false;
            spike.hungry = true;
            System.out.println("Is Tom alive? " + tom.status + ". Is Spike hungry? " + spike.hungry);
        } else {
            tom.status = true;
            spike.hungry = false;
            System.out.println("Is Tom alive? " + tom.status + ". Is Spike hungry? " + spike.hungry);
        }
    }

    public interface Movable        {        void move(int distance);    }
    public interface Eatable        {        boolean eaten();    }
    public interface Eat            {        boolean eat();    }

    public static class Cat implements Eat, Eatable, Movable {
        int geoposition;
        boolean status;
        boolean hungry;
        public boolean eat() {   return hungry;     }
        public boolean eaten() {            return status;        }
        public void move(int distance) {            geoposition += distance;        }
    }

    public static class Mouse implements Eatable, Movable {
        int geoposition;
        boolean status;
        public boolean eaten() {            return status;        }
        public void move(int distance) {        }
    }

    public static class Dog implements Eat, Movable {
        int geoposition;
        boolean hungry;
        public boolean eat() {   return hungry;     }
        public void move(int distance) {        }
    }
}