import org.junit.jupiter.api.Test;

import com.example.Traitement;

public class ThreadsExample {
    @Test
    public void example() {
        System.out.println("Starting main thread");

        Traitement traitA = new Traitement("thread-A", 100);
        traitA.start();

        Traitement traitB = new Traitement("thread-B", 500);
        traitB.start();

        try {
            traitA.join();
            traitB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ending main thread");
    }
}
