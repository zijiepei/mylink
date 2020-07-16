package TcpUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    /*//1.初始化一个socket对象
    private DatagramSocket socket = null;
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    //2.进入主循环
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //a.读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),
                    0,requestPacket.getLength()).trim();
            //b.根据请求计算响应
            String response = process(request);
            //c.把响应写回给客户端
            DatagramPacket responsepacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(requestPacket);
            System.out.printf("[%s : %d] req: %s;resp: %s\n",
                    requestPacket.getAddress().toString(),requestPacket.getPort(),request,response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();;
    }*/
    private DatagramSocket socket = null;
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //1.读取请求并解析
            DatagramPacket datagramPacket1 = new DatagramPacket(new byte[4096],4096);
            socket.receive(datagramPacket1);
            String request = new String(datagramPacket1.getData(),
                    0,datagramPacket1.getLength()).trim();
            //2.根据请求计算响应
            String response = process(request);
            //3.把响应发送客户端
            DatagramPacket datagramPacket2 = new DatagramPacket(response.getBytes(),response.getBytes().length,
            datagramPacket1.getSocketAddress());
            socket.send(datagramPacket2);
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
