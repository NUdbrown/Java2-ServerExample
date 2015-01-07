import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by dbrown on 1/7/2015.
 */
public class EchoClient {
    private static class Sender implements Runnable {
        private static Integer requestNumber = 0;

        @Override
        public void run() {
            try {
                Socket s = new Socket("localhost", 30000);

                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                pw.println("Dia" + (++requestNumber));

                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                System.out.println(br.readLine());
            } catch (IOException i) {
                throw new IllegalStateException();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Sender());
            t.start();
        }


    }
}
