package programming;

import java.util.stream.IntStream;

public class FP05Threads {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
            }
        };

        Runnable runnable2 = () -> IntStream.rangeClosed(0, 10000)
                .forEach(i -> System.out.println(Thread.currentThread().getId() + ":" + i));

        new Thread(runnable2).start();
        new Thread(runnable2).start();
        new Thread(runnable2).start();
    }

}
