package hyperskill.cancurrency.pizza;

public class MainPizza {
    public static void main(String[] args) throws InterruptedException {
        Base base = new Base();
        Tomatoes tomatoes = new Tomatoes();
        Onion onion = new Onion();
        Bake bake = new Bake();
        java.util.List<Thread> stepOfCook = new java.util.ArrayList<>();
        stepOfCook.add(base);
        stepOfCook.add(tomatoes);
        stepOfCook.add(onion);
        stepOfCook.add(bake);
        for (Thread step : stepOfCook) {
            step.start();
            step.join();
        }
    }
}
