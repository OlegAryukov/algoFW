package hyperskill.cancurrency;

interface ExecRunnable {
    public static void startRunnables(Runnable[] runnables) {
        for (Runnable item: runnables) {
            Thread t = new Thread(item);
            t.start();
        }
    }
}
