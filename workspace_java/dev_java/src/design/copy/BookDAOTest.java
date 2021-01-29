package design.copy;

import java.util.List;

import design.book.BookManagerEventHandler;
import design.book.BookVO;

public class BookDAOTest {
	
	public static void main(String[] args) {
		BookManagerEventHandler bmeh = new BookManagerEventHandler();
//		List<BookVO> bList =  bmeh.getBookList();
		List<BookVO> bList =  bmeh.procBookList();
		System.out.println(bList.size());
		for(BookVO bVO:bList) {
			System.out.println(bVO.getB_name());
		}
	}

}
