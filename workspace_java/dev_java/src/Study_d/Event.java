package Study_d;

public class Event {
	public void actionPerformed(ActionEvent e) {
        //String label=e.getActionCommand();이렇게 쓰면 안된다.
        Object obj=e.getSource();
     int i=0;
        if(obj==su.jbtn_conf) {
           //obj는 SignUp에 있는 jbtn_conf랑 같은게 맞니? **obj가 무엇인지 알고있나?
           Vector<ClientlistVO> clientList=sum.ClientList(su.jtf_id.getText());
           //Vector<ClientlistVO>는 clientList로 변수지정=SignUpManager에 있는  ClientList 불러줘(파라미터는 SignUp 있는  jtf_id에서 텍스트값을 받을꺼야)
           //**잘했는데 이거만 좀 아쉽 Vector<ClientlistVO>는 ClientlistVO클래스를 벡터화한거
           for(i=0;i<clientList.size();i++) {
              //변수 i는 clientList.size()보다 작을때까지 계속 실행될꺼야. **clientList는 벡터다 그 벡터의 방갯수만큼 돌리기위해 이 for문을 사용한것
              ClientlistVO cVO=clientList.get(i);
              //ClientlistVO를 변수 cVO로  지정햇어, 위에서 Vector<ClientlistVO>를 
              //변수 clientList로 지정한거에  for문 돌린 i값을 받아올꺼야
              //** 잘했는데 i값을 받아온다의 개념이아니고 clientList를 i횟수만큼 반복한것을 cVO에서 받는다는것 
              System.out.println("su.jtf_id.getText()===>"+su.jtf_id);
              
               if(su.jtf_id.getText().equals(cVO.getB_id())) {
                  //su.jtf_id 텍스트 필드를 받아온것과 오라클 테이블에 올려놓은 cVO.B_id과 텍스트가  같니? 
                  //**20번에 설명을 이어서 하자면 그렇기때문에 cVO.getB_ID가 단순히 하나의 아이디가 아니고 데이터전체의 ID와 비교하는것이 가능해지는것
              JOptionPane.showMessageDialog(su, "ID가 이미 사용중입니다."
                    , "Information", JOptionPane.INFORMATION_MESSAGE);
              //if문이 맞으면 JOptionPane에 메세지 창을 띄워줘(SignUp창에 사용중이란 글이 나오게하고 제목도 지어줘,JOptionPane에 정보를 띄어줘)
           break;
}
