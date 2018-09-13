package f5tech;


    class Animal {
        private final String noise;
        protected Animal(String noise) {
            this.noise = noise;
        }
        public void makeNoise() {
            System.out.println(noise);
        }
        public void numberOfLegs() {
            System.out.println(("We don't know!"));
        }

        public void isReptile() {
            System.out.println("We don't know!");
        }
    }

    class Cat extends Animal {
        public Cat() {
            super("Meow");
        }
        public void numberOfLegs() {
            System.out.println("Four");
        }
    }

    public class Tester {
        public static void main(String args[]) {
            Cat c = new Cat();
            c.makeNoise();;
            c.numberOfLegs();
            c.isReptile();
        }
    }

