import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    private ServerSocket serverSocket = null;
    ///1.初始化服务器
    public TcpEchoServer (int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    private void star() throws IOException {
        System.out.println("服务器启动");
        /////2.进入主循环
        while (true) {
            //1)先获取一个tcp连接
            Socket clientSocket = serverSocket.accept();
            //2)处理这个链接(解决客户端请求的细节)
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d]客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        //这里就是把字节流转为字节流,并且最终带有缓冲区,可以按行读
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            while (true) {
                //a.读取请求并解析
                String requset = bufferedReader.readLine();
                //b.根据请求计算响应
                String response = process(requset);
                //c.把响应写回客户端
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req: %s;resp: %s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),requset,response);
            }
        } catch (IOException e) {
            System.out.printf("[%s:%d]客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    private String process(String requset) {
        return requset;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.star();
    }
}
