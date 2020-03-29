class ThreadDemo2 extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo2(String name) {
        this.threadName = name;
        System.out.println("new threadName = " + threadName);
    }

    public void run() {
        System.out.println("Running" + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread" + threadName + "," + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("threadName + \"interrupted\" = " + threadName + "interrupted");
        }
        System.out.println("threadName = " + threadName + "exiting");
    }

    public void start() {
        System.out.println("Starting" + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}

public class TestThread2 {
    public static void main(String[] args) {
        ThreadDemo2 T1 = new ThreadDemo2("Thread-1");
        T1.start();

        ThreadDemo2 T2 = new ThreadDemo2("Thread-2");
        T2.start();

    }
}
