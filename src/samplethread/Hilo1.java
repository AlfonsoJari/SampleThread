package samplethread;

public class Hilo1 extends Thread {

    private long timesleep = 1;
    private String name="";

    public Hilo1(long sleep, String name) {
        this.timesleep = sleep;
        this.name=name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Un subproceso " + name);
            try {
                sleep(timesleep);
            } catch (InterruptedException e) {
            }
            super.run();
        }
    }
}
