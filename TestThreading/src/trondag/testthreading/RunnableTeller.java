package trondag.testthreading;

public class RunnableTeller implements Runnable{
    private int tellerTil;

    public RunnableTeller(int tellerTil) {
        this.tellerTil = tellerTil;
    }

    @Override
    public void run() {
        for (int i = 0; i <= tellerTil; i = i + 100){
            System.out.println(Thread.currentThread().getName() + " - RT - " + i);
        }
    }
}
