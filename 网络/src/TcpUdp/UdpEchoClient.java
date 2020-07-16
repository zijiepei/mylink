package TcpUdp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    /*private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //1.读取用户输入的数据
            System.out.print("->");
            String request = scanner.nextLine();
            if(request.equals("exit")) {
                break;
            }
            //2.构造请求发送给服务器
            DatagramPacket repuestPacket =
                    new DatagramPacket(request.getBytes(),request.getBytes().length,
                            InetAddress.getByName(serverIp),serverPort);
            socket.send(repuestPacket);
            //3.从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),
                    0,responsePacket.getLength()).trim();
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient =
                new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }*/
    private DatagramSocket socket = null;
    private String ip;
    private int port;
    public UdpEchoClient (String ip,int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        socket = new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //1.读取用户输入的数据
            System.out.print("->");
            String request = scanner.nextLine();
            if(request.equals("exit")) {
                break;
            }
            //2.构造请求,发送给服务器
            DatagramPacket datagramPacket1 = new DatagramPacket(request.getBytes(),
                    request.getBytes().length,InetAddress.getByName(ip),port);
            socket.send(datagramPacket1);
            //3.读取响应
            DatagramPacket datagramPacket2 = new DatagramPacket(new byte[4096],4096);
            socket.receive(datagramPacket2);
            String response = new String(datagramPacket2.getData(),0,datagramPacket2.getLength()).trim();
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }
}
