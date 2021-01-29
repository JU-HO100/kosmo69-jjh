package design.copy;

import java.util.ArrayList;
import java.util.List;

import design.book.BookVO;

public class BookTest {
	/*****************************************
	 * 
	 * @param bVO
	 * @return 0이면 등록 실패, 1이면 등록 성공 - 사용자에게 피드백이 가능하다
	 * query:INSERT INTO book(b_no, b_name, b_name, publish, author
	 * 						 ,b_img)
	 * 			VALUES(SELECT seq_book_no.nextval from dual, '자바의 정석','도우출판사','남궁성'.'java.png')
	 * 																이때 ""이 아닌 ''를 써야한다.
	 *****************************************/
	public int bookInsert(BookVO bVO) {
		return 0;
	}
	public int bookUpdate(BookVO bVO) {
		return 0;
	}
	/******************************************
	 * @param deptno
	 * @return
	 * query : delete from book where b_no = ?
	 ******************************************/
	public int bookDelete(int b_no) {
		return 0;
	}
/*	SELECT ename, sal FROM emp
	WHERE sal >= (SELECT sal FROM emp WHERE empno=:x)   */
	public List<BookVO> bookList(int b_no){          
//		List<BookVO> bList = null;
		List<BookVO> bList = new ArrayList<>();//인스턴스화 - 다이아몬드 연산자로 마무리
		
		return bList;
	}
	/*****************************************
	 * 
	 * @param b_no 		도서번호 - 자동채번하는 시퀀스 활용하기
	 * @param b_name 	도서명
	 * @param b_img		도서 이미지
	 * @param publish
	 * @param author
	 * @return
	 *****************************************/
						//시퀀스를 사용하면 밑의 int를 사용할 필요가 없다.
	public int bookInsert(/*int b_no,*/ String b_name, String b_img 
							,String publish, String author) {
		return 0;
	}
	public static void main(String[] args) {
		
	}
}
