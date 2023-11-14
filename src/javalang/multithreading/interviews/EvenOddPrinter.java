package javalang.multithreading.interviews;

public class EvenOddPrinter {
    private static final int MAX = 100;
    private static final Object lock = new Object();
    private static boolean isEven = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new OddPrinter());
        Thread thread2 = new Thread(new EvenPrinter());

        thread1.start();
        thread2.start();
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= MAX; i += 2) {
                synchronized (lock) {
                    while (!isEven) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Thread 1: " + i);
                    isEven = false;
                    lock.notify();
                }
            }
        }
    }

    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= MAX; i += 2) {
                synchronized (lock) {
                    while (isEven) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Thread 2: " + i);
                    isEven = true;
                    lock.notify();
                }
            }
        }
    }
}

