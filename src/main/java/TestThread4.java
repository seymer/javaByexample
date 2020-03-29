class PrintDemo4 {
    public void printCount() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter ---- " + i);
            }
        } catch (Exception e) {
            System.out.println("Thread interrupted");
        }
    }
}

class ThreadDemo4 extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo4 PD;

    ThreadDemo4(String name, PrintDemo4 pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        synchronized (PD) {
            PD.printCount();
        }
        System.out.println("Thread" + threadName + "exiting");
    }

    public void start() {
        System.out.println("Starting" + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}

public class TestThread4 {
    public static void main(String[] args) {
        PrintDemo4 PD = new PrintDemo4();

        ThreadDemo4 T1 = new ThreadDemo4("Thread-1", PD);
        ThreadDemo4 T2 = new ThreadDemo4("Thread-2", PD);

        T1.start();
        T2.start();

        // wait for threads to end
        try {
            T1.join();
            T2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}
