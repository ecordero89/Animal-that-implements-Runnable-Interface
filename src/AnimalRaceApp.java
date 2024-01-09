//Elizabeth Cordero
//COP3330C-14834
//09/21/2023

public class AnimalRaceApp {
    public static void main(String[] args) {
        Food sharedFood = new Food();
        Animal hare = new Animal("Hare", 40, 100, sharedFood);
        Animal tortoise = new Animal("Tortoise", 20, 500, sharedFood);

        Thread hareThread = new Thread(hare);
        Thread tortoiseThread = new Thread(tortoise);

        hareThread.start();
        tortoiseThread.start();
    }
}
