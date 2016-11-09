/**
 * Created by x3727349s on 09/11/16.
 */
public class HeretaFils implements Runnable{

    private final int i;
    String strImprimir;

    public HeretaFils(String strP, int i) {
        this.i = i;
        strImprimir = strP;

    }


    public void run(){
        for(int i=0; i<10;i++){
            System.out.println(strImprimir+" "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int argSize = Integer.parseInt(args[0]);

        int[] w = new int[argSize];

        Thread myThreads[] = new Thread[argSize];
        for (int j = 0; j < argSize; j++) {
            String strp="";
            myThreads[j] = new Thread(new HeretaFils(strp,j));
            myThreads[j].start();
        }
        for (int j = 0; j < argSize; j++) {
            myThreads[j].start();
            myThreads[j].join(); //todo add catch exception
        }


    }

}