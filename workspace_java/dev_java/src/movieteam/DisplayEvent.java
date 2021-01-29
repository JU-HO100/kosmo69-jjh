package movieteam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class DisplayEvent extends JDialog implements ActionListener {
	Display d = null;
	Display3 d3 = new Display3(this);
	
	
	
	public DisplayEvent(Display display) {
		this.d = display;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == d.jbtn_info1) {
           System.out.println("호출");
           d.jbtn_x1.setBounds(320,430,50,20);
           d.jta.setText("");
           d.jta.setBounds(70, 50, 300, 400);
           d.jta.append("태국에서 충격적인 납치사건이 발생하고\n" + 
        " 마지막 청부살인 미션을 끝낸 암살자 인남(황정민)은\n"+
        " 그것이 자신과 관계된 것임을 알게 된다.\n" + 
        " 인남은 곧바로 태국으로 향하고, 조력자 유이(박정민)를 만나\n"+ "사건을 쫓기 시작한다.\n" + 
        " 한편, 자신의 형제가 인남에게 암살당한 것을 알게 된 레이(이정재).\n" + 
        " 무자비한 복수를 계획한 레이는 인남을 추격하기 위해 태국으로 향하는데...\n" + 
        " \n" + 
        " 처절한 암살자 VS 무자비한 추격자\n" + 
        " 멈출 수 없는 두 남자의 지독한 추격이 시작된다!");
           
           d.jta.setVisible(true);            
           d.jbtn_x1 .setVisible(true);
           d.jbtn_x2.setVisible(false);
           d.jbtn_x3.setVisible(false);
        //   jbtn_info1.setVisible(false);
        }else {
       	 d.jta.setVisible(false);
       	 d.jbtn_x1.setVisible(false);
        }
        if (obj == d.jbtn_info2) {
       	   d.jbtn_x2.setBounds(720,430,50,20);
           d.jta.setText("");
           d.jta.setBounds(470, 50, 300, 400);
           d.jta.setText("남북미 정상회담 중, 북한 내 쿠데타로 세 정상이 납치된다!\n" + 
                 "북미 평화협정 체결을 위한 대한민국 대통령(정우성),\n" + 
                 "북한의 최고지도자인 위원장(유연석)과 미국 대통령(앵거스 맥페이든)간의 남북미 정상회담이\n" + 
                 "북한 원산에서 열린다. 북미 사이 좀처럼 이견이 좁혀지지 않는 가운데,\n" + 
                 "핵무기 포기와 평화체제 수립에 반발하는 북 호위총국장(곽도원)의 쿠데타가 발생하고,\n" + 
                 "납치된 세 정상은 북한 핵잠수함에 인질로 갇힌다. \n" + 
                 "그리고, 좁디 좁은 함장실 안, 예기치 못한 진정한 정상회담이 벌어지게 되는데…\n" + 
                 "\r\n" + 
                 " 동북아시아의 운명이 핵잠수함에 갇혔다!\n" + 
                 " 과연, 남북미 세 지도자는 전쟁 위기를 막을 수 있을 것인가?\n");
           d.jta.setVisible(true);   
           d.jbtn_x2.setVisible(true);
           d.jbtn_x1.setVisible(false);
           d.jbtn_x3.setVisible(false);
           //jlb_mv2.setVisible(false);
           //jlb_mv3.setVisible(false);
        }
        if (obj == d.jbtn_info3) {
       	   d.jbtn_x3.setBounds(1120,430,50,20);
           d.jta.setText("");
           d.jta.setBounds(870, 50, 300, 400);
           d.jta.setText("머나먼 사막 속 신비의 아그라바 왕국의 시대.\r\n" + 
                 " 좀도둑 ‘알라딘’은 마법사 ‘자파’의 의뢰로 마법 램프를 찾아 나섰다가\r\n" + 
                 " 주인에게 세 가지 소원을 들어주는 지니를 만나게 되고,\r\n" + 
                 " 자스민 공주의 마음을 얻으려다 생각도 못했던 모험에 휘말리게 되는데…");
           d.jta.setVisible(true);
           d.jlb_mv1.setVisible(false);
           d.jbtn_x3.setVisible(true);
           d.jbtn_x2.setVisible(false);
           d.jbtn_x1.setVisible(false);
        }
        if(obj == d.jbtn_x1) {
           d.jta.setVisible(false);
           d.jbtn_x1.setVisible(false);
        }
        if(obj == d.jbtn_x2) {
           d.jta.setVisible(false);
           d.jbtn_x2.setVisible(false);
        }
        if(obj == d.jbtn_x3) {
           d.jta.setVisible(false);
           d.jbtn_x3.setVisible(false);
        }
        if(obj == d.jbtn_pay1) {
       	 d.setVisible(false);
       	 d3.initDisplay();
        }
        if(obj == d.jbtn_pay2) {
       	 d.setVisible(false);
       	 d3.initDisplay();
        }
        if(obj == d.jbtn_pay3) {
       	 d.setVisible(false);
       	 d3.initDisplay();
        }
        if(obj == d.jbtn_back) {
       	 d.setVisible(false);
       	 d3.initDisplay();
        }
        else if(obj == d3.jbtn_back) {
        	d3.setVisible(false);
        	d.initDisplay();
        }
	}

}
