package design.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class BookManagerEvent extends Handler implements ActionListener {
	BookManagerMain bmm = null;
	
	public BookManagerEvent(BookManagerMain bmm) {//생성자
		this.bmm = bmm;//초기화 this 클래스 내부
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void publish(LogRecord arg0) {
		// TODO Auto-generated method stub
		
	}

}
