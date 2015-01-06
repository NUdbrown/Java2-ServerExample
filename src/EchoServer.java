import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dbrown on 1/5/2015.
 */
public class EchoServer {
    public static void main(String[]args) throws IOException{
        ServerSocket ss = new ServerSocket(30000);

        Socket sock = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter pw = new PrintWriter(sock.getOutputStream(),true);

        pw.println(br.readLine());
        

    }
}
