package teambbg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class BaseBallGameEnent extends Handler implements ActionListener {
	 	BaseBallGameView bbgv = null;
	 	BaseBallGameLogic bbgl = null;
	   
	   public BaseBallGameEnent(BaseBallGameView bbgv,BaseBallGameLogic bbl) {
	      this.bbgv = bbgv;
	      this.bbgl = bbl;
	   }
	   
	   public BaseBallGameEnent() {      
	  
	   }

	@Override
	   public void actionPerformed(ActionEvent e) {
	      System.out.println("actionPerformed 호출 성공");
	      String label =  e.getActionCommand();
	      System.out.println("당신이 누른 버튼의 문자열은 "+label+" 입니다.");
	      Object obj = e.getSource();//이벤트소스의 주소번지를 담아줌.
	      if("나가기".equals(label)) {
	      //if(obj==jbtn_exit||obj==jmi_exit) {
	         System.exit(0);
	      }
	      else if(e.getSource()==bbgv.jtf_user){
	         bbgv.jta_display.append(bbgl.cnt++ +"회차. "+bbgv.jtf_user.getText()+" : "+bbgl.account(bbgv.jtf_user.getText())+"\n");
	         bbgv.jtf_user.setText("");
	      }
	      else if(obj==bbgv.jbtn_new) {
	         bbgl.ranCom();
	         bbgv.jta_display.setText("");
	         bbgv.jtf_user.setText("");
	         bbgv.jtf_user.requestFocus();
	         
	      }
	      else if(obj==bbgv.jbtn_dap) {
	         bbgv.jta_display.append("정답은 "+bbgl.com[0]+bbgl.com[1]+bbgl.com[2]+"\n");
	      }
	      else if(obj==bbgv.jbtn_clear) {
	         bbgv.jta_display.setText("");
	         bbgv.jtf_user.setText("");
	         bbgv.jtf_user.requestFocus();
	      }
	   }


		@Override
			public void close() throws SecurityException {
				// TODO Auto-generated method stub
	      
	   }

	   @Override
	   		public void flush() {
		   		// TODO Auto-generated method stub
	      
	   }

	   @Override
	   		public void publish(LogRecord record) {
		   		// TODO Auto-generated method stub
	      
	   }
}
