package lab6;

public class MultiThreading {
    private static final Object lock = new Object();
    public static void main(String[] args) {
        play p = new MultiThreading().new play();
        play1 p1 = new MultiThreading().new play1();

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p1);

        t1.start();
        t2.start();
    }

    private class play implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 5; i++) {
                synchronized (lock) {
                    System.out.println("Hello DCOMS");
                    lock.notify();;
                    try {
                        lock.wait();;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private class play1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 5; i++) {
                synchronized (lock) {
                    System.out.println("Welcome to MultiThreading Programming");
                    lock.notify();;
                    try {
                        if (i < 5) {
                            lock.wait();;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
