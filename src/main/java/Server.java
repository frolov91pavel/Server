import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    int POOL = 64;
    ExecutorService executorService = Executors.newFixedThreadPool(POOL);

    public void listen(int port) {

        try (final var ServerSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = ServerSocket.accept();
                System.out.println(socket);
                Handler handler = new Handler(socket);
                executorService.submit(handler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}