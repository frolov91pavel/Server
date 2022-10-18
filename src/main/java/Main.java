
public class Main {

    final static int PORT = 8081;

    public static void main(String[] args) {
        Server server = new Server();
        server.listen(PORT);
    }

}