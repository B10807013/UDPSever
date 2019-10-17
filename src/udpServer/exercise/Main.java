package udpServer.exercise;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args){
        final int PORT = 8000;

        try{
            DatagramSocket ds = new DatagramSocket(PORT);
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            while(true){
                ds.receive(dp);
                String s = new String(dp.getData(), 0, dp.getLength());
                System.out.println("receive: " + s);
            }
            //由於是sever，不需要close()
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
