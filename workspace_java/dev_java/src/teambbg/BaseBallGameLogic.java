package teambbg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class BaseBallGameLogic {
//    BaseBallGameView vi = new BaseBallGameView();
    
   int my[] = new int[3];
   int com[] = new int[3];
   int cnt = 0;
   
public void ranCom() {
      com[0] = (int)(Math.random()*10);
      do {
         com[1] = (int)(Math.random()*10);
      }while(com[0] ==com[1]);
      do {
         com[2] = (int)(Math.random()*10);
      }while(com[1]==com[2]||com[0]==com[2]);
}
public String account(String user) {
   int temp = 0;
   int strike = 0; 
   int ball = 0; 
   temp= Integer.parseInt(user);
   my[0] = temp/100;
   my[1] = (temp%100)/10;
   my[2] = temp%10;
   JOptionPane.showMessageDialog(null, my[0]+""+my[1]+""+my[2]);
   for(int i=0;i<3;i++) {
      for(int j=0; j<3;j++) {
         if(my[i]==com[j]) {//너 안에 내가 가진 숫자가 있는거야?
            if(i==j) { //그러면 자리까지 일치하는거냐?
               strike++;
            }
            else {
            	ball++;
            }
         }
      }
   }
   if(strike==3) {
      return "정답입니다";
   }
   return strike+"스트라이크 "+ball+" 볼";
}
}
