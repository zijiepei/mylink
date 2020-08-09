import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //1.进行初始化操作,初始化一个socket对象
     private DatagramSocket socket = null;
     public UdpEchoServer(int port) throws SocketException {
         socket = new DatagramSocket(port);
     }
     //2.进入主循环
     public void start() throws IOException {
         System.out.println("服务器启动");
         while (true) {
             //a)读取并解析请求
             DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
             socket.receive(requestPacket);
             String request = new String(requestPacket.getData(),0,requestPacket.getLength()).trim();
             //b)根据请求计算响应
             String response = process(request);
             //c)把响应写回客户端
             DatagramPacket responsePacket = new DatagramPacket(request.getBytes(),
                     request.getBytes().length,requestPacket.getSocketAddress());
             socket.send(requestPacket);
             //////////打印一下请求和回应的日志
             System.out.printf("[%s:%d] req: %s;resp: %s\n",requestPacket.getAddress().toString(),
                     requestPacket.getPort(),request,response);
         }
     }

    private String process(String request) {
         return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
