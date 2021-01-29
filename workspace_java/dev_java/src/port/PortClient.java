package port;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JLabel;

import book.ch8.TimeClient;

public class PortClient extends Thread {
	private JLabel jlb_time = null; //new JLabel();
	public PortClient(JLabel jlb_time) {
	this.jlb_time = jlb_time;
	}

	public PortClient() {
   }

   // run() 시작
   public void run() {

      Socket socket = null;
      PrintWriter out = null;
      BufferedReader in = null;
      String timeStr = null;

      try {
         socket = new Socket("192.168.0.38", 2000);
         out = new PrintWriter(socket.getOutputStream(), true);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         while(true) {
            while((timeStr = in.readLine()) != null)
               jlb_time.setText(timeStr);
            try {
               sleep(1000);
            } catch(InterruptedException i) {
               System.out.println("InterruptedException "+i.toString());
            }
         }

      } catch(IOException i) {
//         label.setText("타임서버에 접속할 수 없습니다.");
         System.out.println("타임서버에 접속할 수 없습니다.");
      } finally {
         try {
            in.close();
            out.close();
            socket.close();
         } catch (IOException e) {}
      }
   }
   // run() 종료
   public static void main(String args[]){
	   PortClient tc = new PortClient();
      tc.start();
   }
}
