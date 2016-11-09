import java.util.concurrent.Semaphore;

/**
 * Created by x3727349s on 09/11/16.
 */

    class ArrayThreading  {
        private int[] array;
        private Semaphore allDone;

    // The array contains the values
        // 0, 1, 2... len-1
        public ArrayThreading(int len) {
            array = new int[len];
            for (int i=0; i<len; i++) {
                array[i] = i%10;
            }
        }
        private class Worker extends Thread {
            int start;
            int end;
            long sum;
            // Note the start and end indexes for this worker
            // in the array. Goes up to but not including end index.

            Worker(int start, int end) {
                this.start = start;
                this.end = end;
                sum = 0;
            }

            public void run() {
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                allDone.release();
            }

            public long getSum() {
                return sum;


            }


        }


    }
