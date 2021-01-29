package book.ch8;
import java.net.*;
import java.util.StringTokenizer;
import java.io.*;

import javax.swing.*;

public class TimeClient extends Thread {
	private JLabel jlb_time = null; //new JLabel();
	public TimeClient(JLabel jlb_time) {
	this.jlb_time = jlb_time;
	}

	public TimeClient() {
   }

   // run() 시작
   public void run() {

      Socket socket = null;
      PrintWriter out = null;
      BufferedReader in = null;
      String timeStr = null;

      try {
         socket = new Socket("192.168.0.38", 5000);
         out = new PrintWriter(socket.getOutputStream(), true);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         while(true) {
            while((timeStr = in.readLine()) != null)
               //System.out.println(timeStr);
               jlb_time.setText(timeStr);
            	//label.setText(timeStr);
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
      TimeClient tc = new TimeClient();
      tc.start();
   }
}