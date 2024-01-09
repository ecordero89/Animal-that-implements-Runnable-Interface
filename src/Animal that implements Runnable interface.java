//Elizabeth Cordero
//COP3330C-14834
//09/21/2023

import java.util.Random;
class Food {
    public synchronized void eat(String animalName) {
        System.out.println(animalName + " starts eating.");
        try {

            // Simulate eating for a random amount of time
            Thread.sleep(new Random().nextInt(10) + 5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(animalName + " is done eating.");
    }
}

class Animal implements Runnable {
    private String name;
    private int distanceTraveled;
    private int restMax;
    private Food food;

    public Animal(String name, int distanceTraveled, int restMax, Food food) {
        this.name = name;
        this.distanceTraveled = distanceTraveled;
        this.restMax = restMax;
        this.food = food;
    }

    public void run() {
        while (distanceTraveled < 120) {
            rest();
            moveForward();
            System.out.println(name + " is at position " + distanceTraveled);
            if (distanceTraveled >= 120) {
                System.out.println(name + " wins the race!");
                Food food = new Food();
                food.eat(name);
                break;
            }
        }
    }
    private synchronized void rest() {
        try {
            Thread.sleep(new Random().nextInt(restMax));
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    private synchronized void moveForward() {
        distanceTraveled += new Random().nextInt(10) + 1;
    }
}
