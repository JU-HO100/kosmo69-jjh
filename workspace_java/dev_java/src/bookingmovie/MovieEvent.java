package bookingmovie;
import java.awt.Color;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import bookingmovie.PayDAO;

public class MovieEvent extends JDialog implements MouseListener, ActionListener, ItemListener {
	Display 		d 			= null;
  	String 		id 			= null;
	String 		pw 		= null;
	String 		mcode 	= null;
	String date = null;
	String time = null;
	String seq = null;
	String sldseat[] = null;
	String savedinfo[]=null;
	MovieSeatDAO msdao = new MovieSeatDAO(this);
	PayDAO pdao 		= new PayDAO(this);
	String today = "2020/09/11";
	String seat_code = null;
//	MovieDAO mdao = new MovieDAO(this);
	
	public MovieEvent() {
	}
	public MovieEvent(Display d) {
		this.d = d;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	// Strat //
	    /////////////////////////// 로 그 인 화 면 - 로 그 인 버 튼	처 리 ///////////////////////////
        if(obj == d.jbtn_login) {
       	 id = d.id_t.getText();
       	 pw = d.pw_t.getText();
       	 int check_id 		=	d.md.memberCheckID(id);
       	 int check_pw 	= d.md.memberCheckPW(pw);
//			 테스트
//       	 System.out.println(check_id);
//       	 System.out.println(check_pw);
	       	 if ((0 == check_id)) {
	       		 JOptionPane.showMessageDialog(null, "아이디를 확인해주세요.");
	       	 }
	       	 else if ( 1 == check_id) {
	       		 if ((0 == check_pw)||(pw==" ")) {
	       			 JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요.");
	       		 }
	       		 else if ( 1 == check_pw) {
	       		 JOptionPane.showMessageDialog(null, "로그인 완료");
	       		 d.jfl.dispose();
	       		 d.MovieSelect();
	       		 id = d.id_t.getText();
	       		 d.md.ins_t_booknum(id);
	       		 seq = d.md.getSEQVal(id);
	       		 }
	       		 System.out.println(id);
	       	 }
        }
        else if( obj == d.jbtn_join) {
        	d.joinDisplay();
        }
        else if ( obj == d.jbtn_pclose) {
        	d.dispose();
        }
        /////////////////////////// 로 그 인 화 면 - 로 그 인 버 튼	처 리 ///////////////////////////
        
    	// Strat //
		////////////////////////////가입화면창 회원가입, 나가기 버튼 ////////////////////////////
		if(obj == d.jbtn_joinclose) {
			d.jf.dispose();
		}
		if(obj == d.jbtn_ins) {
			
//			테스트
//			System.out.println(d.jtf_joinid.getText());
			String id = d.jtf_joinid.getText();
			String pw = d.jpf_joinpw.getText();
			String memname = d.jtf_memname.getText();
			String phone = d.jtf_phone.getText();
			int check = d.md.memberCheckID(id);

			if( ("").equals(id.trim()) ) {
				JOptionPane.showMessageDialog(null, "가입할 ID를 입력해주세요.");
				}
			else if( ("").equals(pw.trim()) ) {
				JOptionPane.showMessageDialog(null, "가입할 pw를 입력해주세요.");
			}	
			else if( ("").equals(memname.trim()) ) {
				JOptionPane.showMessageDialog(null, "가입할 이름를 입력해주세요.");
			}
			else if( ("").equals(phone.trim()) ) {
				JOptionPane.showMessageDialog(null, "가입할 전화번호를 입력해주세요.");
			}
			else if( id.contains(" ") ) {
				JOptionPane.showMessageDialog(null, "ID 안에 공백이 있습니다. ID를 확인해주세요.");
			}
			else if( pw.contains(" ") ) {
				JOptionPane.showMessageDialog(null, "ID 안에 공백이 있습니다. PW를 확인해주세요.");
			}
			else if( memname.contains(" ") ) {
				JOptionPane.showMessageDialog(null, "ID 안에 공백이 있습니다. 이름를 확인해주세요.");
			}
			else if( phone.contains(" ") ) {
				JOptionPane.showMessageDialog(null, "ID 안에 공백이 있습니다. 전화번호를 확인해주세요.");
			}
			else if (check == 1) {
				JOptionPane.showMessageDialog(null, "이미 있는 ID입니다. ID 중복 체크를 확인해주세요.");
			}
			else if (check == 0) {
				int result = JOptionPane.showConfirmDialog(null, "가입하시겠습니까?", "가입확인", JOptionPane.YES_NO_OPTION);
				if ( result == JOptionPane.CLOSED_OPTION ) {
					//사용자가 예, 아니오 의 선택 없이 닫은 경우.
				}	else if ( result == JOptionPane.YES_NO_OPTION ) {
					d.md.join(id, pw, memname, phone);
					JOptionPane.showMessageDialog(null, "회원가입이 완료 되었습니다. 감사합니다..");
					d.jf.dispose();
				}	else {
					d.jf.dispose();
				}
			}
			////////////////////////////가입화면창 회원가입, 나가기 버튼 ////////////////////////////
			}
//		'%'||id||'%'
		
    	// Strat //
		//////////////////////////// 아 이 디 중 복 체 크 ////////////////////////////
		if(obj == d.jbtn_maching) {
			String id = d.jtf_joinid.getText();
			int check = d.md.memberCheckID(id);
//			테스트
//			System.out.println(id.contains(" "));
			if ( id.contains(" ") ) {
				JOptionPane.showMessageDialog(null, "ID 안에 공백이 있습니다. ID를 확인해주세요.");
				return;
			}
			if( ("").equals(id.trim()) ) {
				JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
			}
			else if( check == 1 ) {
				JOptionPane.showMessageDialog(null, "이미 있는 ID입니다.");
			}
			else if ( check == 0) {
				JOptionPane.showMessageDialog(null, "가입 가능한 ID입니다.");
			}
			}
		//////////////////////////// 아 이 디 중 복 체 크 ////////////////////////////
        
		
    	// Strat //
		//////////////////////////// 영 화 호 출 ////////////////////////////
        if(obj == d.jbtn_info1) {
           d.jbtn_x1.setBounds(320,450,50,20);
           d.jta.setText("");
           d.jsp_m.setBounds(70, 50, 300, 400);
//           d.jta.setBounds(70, 50, 300, 400);
           d.jta.append(
        		   "영화제목 : " +"\n"+d.md.getMovieList("M001").getTitle()+"\n"+" "+"\n"
		        		   + "장르 : "+"\n"+d.md.getMovieList("M001").getGenre()+"\n"+" "+"\n"
		        		   + "영화감독 : "+"\n"+d.md.getMovieList("M001").getDirector()+"\n"+" "+"\n"
		        		   + "출연배우 : "+"\n"+d.md.getMovieList("M001").getActor()+"\n"+" "+"\n"
		        		   + "런닝타임 : "+"\n"+d.md.getMovieList("M001").getRunning_time()+"\n"+" "+"\n"
		        		   + "줄거리 : "+"\n"+d.md.getMovieList("M001").getStory()+"\n"+" "+"\n"
        		   );
           
           d.jsp_m.setVisible(true);
           d.jbtn_x1 .setVisible(true);
           d.jbtn_x2.setVisible(false);
           d.jbtn_x3.setVisible(false);
//           jbtn_info1.setVisible(false);
        }	else {
        	d.jsp_m.setVisible(false);
        	d.jbtn_x1.setVisible(false);
        }
        if (obj == d.jbtn_info2) {
        	d.jbtn_x2.setBounds(720,450,50,20);
        	d.jta.setText("");
        	d.jsp_m.setBounds(470, 50, 300, 400);
//			d.jta.setBounds(470, 50, 300, 400);
			d.jta.setText(
	        		   "영화제목 : " +"\n"+d.md.getMovieList("M002").getTitle()+"\n"+" "+"\n"
	                		   + "장르 : "+"\n"+d.md.getMovieList("M002").getGenre()+"\n"+" "+"\n"
	                		   + "영화감독 : "+"\n"+d.md.getMovieList("M002").getDirector()+"\n"+" "+"\n"
	                		   + "출연배우 : "+"\n"+d.md.getMovieList("M002").getActor()+"\n"+" "+"\n"
	                		   + "런닝타임 : "+"\n"+d.md.getMovieList("M002").getRunning_time()+"\n"+" "+"\n"
	                		   + "줄거리 : "+"\n"+d.md.getMovieList("M002").getStory()+"\n"+" "+"\n"
	                		   );
			d.jsp_m.setVisible(true);   
			d.jbtn_x2.setVisible(true);
			d.jbtn_x1.setVisible(false);
			d.jbtn_x3.setVisible(false);
			//jlb_mv2.setVisible(false);
			//jlb_mv3.setVisible(false);
        }
        if (obj == d.jbtn_info3) {
        	d.jbtn_x3.setBounds(1120,450,50,20);
//        	d.jta.setText("");
        	d.jsp_m.setBounds(870, 50, 300, 400);
//        	d.jta.setBounds(870, 50, 300, 400);
        	d.jta.setText(
	         		   "영화제목 : " +"\n"+d.md.getMovieList("M003").getTitle()+"\n"+" "+"\n"
	                		   + "장르 : "+"\n"+d.md.getMovieList("M003").getGenre()+"\n"+" "+"\n"
	                		   + "영화감독 : "+"\n"+d.md.getMovieList("M003").getDirector()+"\n"+" "+"\n"
	                		   + "출연배우 : "+"\n"+d.md.getMovieList("M003").getActor()+"\n"+" "+"\n"
	                		   + "런닝타임 : "+"\n"+d.md.getMovieList("M003").getRunning_time()+"\n"+" "+"\n"
	                		   + "줄거리 : "+"\n"+d.md.getMovieList("M003").getStory()+"\n"+" "+"\n"
	                		   );
        	d.jsp_m.setVisible(true);
        	d.jlb_mv1.setVisible(false);
        	d.jbtn_x3.setVisible(true);
        	d.jbtn_x2.setVisible(false);
        	d.jbtn_x1.setVisible(false);
        }
        if(obj == d.jbtn_x1) {
        	d.jsp_m.setVisible(false);
            d.jta.setText("");
        	d.jbtn_x1.setVisible(false);
        	
        }
        if(obj == d.jbtn_x2) {
        	d.jsp_m.setVisible(false);
        	d.jta.setText("");
        	d.jbtn_x2.setVisible(false);
        }
        if(obj == d.jbtn_x3) {
        	d.jsp_m.setVisible(false);
        	d.jta.setText("");
        	d.jbtn_x3.setVisible(false);
        }
        if(obj == d.jbtn_pay1) {
        	d.label_poster = new JLabel(d.micon1);
        	d.initDisplay3();
        	d.jf1.dispose();
        	mcode = "M001";
        	d.md.upd_m_code(mcode, d.md.getMovieList(mcode).getTitle(),seq);
        	d.md.refreshData(today, mcode);
        	for(int i=0;i<d.dtm_sche.getRowCount();i++) {
				  String s_code = (String)d.dtm_sche.getValueAt(i, 2);
				  d.dtm_sche.setValueAt(msdao.real_seatinfo(s_code), i, 2);
				  msdao.savedseat = new ArrayList<>();
//				  System.out.println(msdao.real_seatinfo(s_code));
//				  msdao.savedseat = new ArrayList<>();
				}
        }
        if(obj == d.jbtn_pay2) {
        	d.label_poster = new JLabel(d.micon2);
        	d.initDisplay3();
        	d.jf1.dispose();
        	mcode = "M002";
        	d.md. upd_m_code(mcode, d.md.getMovieList(mcode).getTitle(),seq);
        	d.md.refreshData(today, mcode);
        	for(int i=0;i<d.dtm_sche.getRowCount();i++) {
				  String s_code = (String)d.dtm_sche.getValueAt(i, 2);
				  d.dtm_sche.setValueAt(msdao.real_seatinfo(s_code), i, 2);
				  msdao.savedseat = new ArrayList<>();
//				  System.out.println(msdao.real_seatinfo(s_code));
//				  msdao.savedseat = new ArrayList<>();
				}
        }
        if(obj == d.jbtn_pay3) {
        	d.label_poster = new JLabel(d.micon3);
        	d.initDisplay3();
        	d.jf1.dispose();
        	mcode = "M003";
        	d.md. upd_m_code(mcode, d.md.getMovieList(mcode).getTitle(),seq);
        	d.md.refreshData(today, mcode);
        	for(int i=0;i<d.dtm_sche.getRowCount();i++) {
				  String s_code = (String)d.dtm_sche.getValueAt(i, 2);
				  d.dtm_sche.setValueAt(msdao.real_seatinfo(s_code), i, 2);
				  msdao.savedseat = new ArrayList<>();
//				  System.out.println(msdao.real_seatinfo(s_code));
//				  msdao.savedseat = new ArrayList<>();
				}
        }
////////////////////////////////스케줄선택화면 ///////////////////////////////////
        if (obj == d.jb_p) {
        	System.out.println("좌석선택화면넘어가는버튼");
        	int index[] = d.jtb_sche.getSelectedRows();
			if(index.length == 0) {
				JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하시오.");
				return;
			}
			else if(index.length >= 2) {
				JOptionPane.showMessageDialog(this, "데이터를 한 건만 선택하시오.");
				return;	
			}
			else {
				date = (String) d.dtm_sche.getValueAt(index[0], 0);
				time = (String) d.dtm_sche.getValueAt(index[0], 1);
				System.out.println(date+", "+time);
				d.initDisplay4(msdao.getSeatCode(date, time));
				System.out.println("테스트"+msdao.getSeatCode(date, time));
				seat_code = msdao.getSeatCode(date, time);
				String m_time = date+" - "+time;
				d.md.upd_m_time(m_time, seat_code, seq);
				d.jf3.dispose();

			}
			
			
////////////////////////////////좌석선택화면 ///////////////////////////////////	
				
			
        }
    	if(obj==d.mjbtn_next) {	
    		d.seatinfo = new ArrayList<>();
			for(int i=0; i<6 ; i++) {
				for(int j = 0 ; j<5	; j++) {
					if(d.seat[j][i].isSelected()==true) {
					d.seatinfo.add(d.seat[j][i].getText());		
					}
				}
		}
			if(d.seatinfo.size()>4) {
				JOptionPane.showMessageDialog(null, "최대 4좌석까지 선택가능합니다.");
				d.seatinfo = new ArrayList<>();
			}
			else {
				System.out.println("다음버튼작동");
				int j = 0;
				sldseat = new String[d.seatinfo.size()];
				for(String temp : d.seatinfo) {
					sldseat[j]= temp;
					j++;
				}
				String s = msdao.getSeatCode(date, time);
				msdao.upd_t_booknum(d.md.getSEQVal(id));
				d.Pay();
				pdao.payInfo(seq);
				savedinfo = new String[pdao.saved_info.size()];
				for(String temp1 : pdao.saved_info) {
					System.out.println(temp1);
				}

				String booknum = pdao.saved_info.get(0)+pdao.saved_info.get(2)+pdao.saved_info.get(5);
				d.jta_num.setText(booknum);
				d.jta_movie.setText(pdao.saved_info.get(1));
				d.jta_day.setText(pdao.saved_info.get(3));
				d.jta_pay.setText(pdao.saved_info.get(4));
				String temp = pdao.saved_info.get(5);
				for(int i=6;i<pdao.saved_info.size();i++){
					if(pdao.saved_info.get(i).equals(null)==false) {
						temp += "  "+pdao.saved_info.get(i);
					}	
				}
				d.jta_seat.setText(temp);
				d.mjf.dispose();

			}
		}
    	
    	//////////////end of  next버튼 ///////////////////
    	if(obj == d.jbtn_cance) {
    		d.jf_pay.dispose();
    		d.initDisplay3();
    		d.seatinfo = new ArrayList<>();
    		pdao.changeTimeSeat(seq);
    	}
    	else if(obj == d.jbtn_in) {
    		//콤보박스값 가져오기
    		String way = d.jcb_pay.getSelectedItem().toString();
    		if ( way == "결제방법" ) {
    			JOptionPane.showMessageDialog(null, "결제방법을 선택해주세요.");
    			return;
    		}
    		else  {
    		d.jta_way.setText(way);
    		
    		d.jf_pay.dispose();
    		d.clear();
    		}
    		
    	}
    	if(obj == d.jbtn_pclose) {
    		pdao.lastIn2(seq);
    		pdao.lastIn1(d.jta_num.getText(),seq);
    		msdao.updSeat(d.jta_num.getText(), seat_code);
    		System.exit(0);
    	}
	} 
		 
	private void appendToPane(JTextArea jta, String string, Color black) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent ec) {
		if(ec.getClickCount()==2) {
			System.out.println("더블 클릭 한거야");
			
			int index[] = d.jtb_sche.getSelectedRows();
			if(index.length == 0) {
				JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하시오.");
				return;
			}
			else if(index.length >= 2) {
				JOptionPane.showMessageDialog(this, "데이터를 한 건만 선택하시오.");
				return;	
			}
			else {
				String date = (String) d.dtm_sche.getValueAt(index[0], 0);
				String time = (String) d.dtm_sche.getValueAt(index[0], 1);
				System.out.println(date+", "+time);
				System.out.println(msdao.getSeatCode(date, time));
				d.initDisplay4(msdao.getSeatCode(date, time));
				seat_code = msdao.getSeatCode(date, time);
				String m_time = date+" - "+time;
				d.md.upd_m_time(m_time, seat_code, seq);
				d.jf3.dispose();

				
			}
		}
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == d.jcb_day) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
//				테스트용
				System.out.println(d.jcb_day.getSelectedItem().toString());
				d.md.refreshData(d.jcb_day.getSelectedItem().toString(), mcode);

				for(int i=0;i<d.dtm_sche.getRowCount();i++) {
				  String s_code = (String)d.dtm_sche.getValueAt(i, 2);
				  d.dtm_sche.setValueAt(msdao.real_seatinfo(s_code), i, 2);
				  msdao.savedseat = new ArrayList<>();
//				  System.out.println(msdao.real_seatinfo(s_code));
//				  msdao.savedseat = new ArrayList<>();
				}
				
			}
		}
	}
}