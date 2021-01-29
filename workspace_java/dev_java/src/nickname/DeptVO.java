package nickname;

public class DeptVO {//VO = Value Object의 약자
//팀장들은 실력에 차이가 들어나는걸 싫어합니다.
//틀을 짜두고 그 틀에 업무에 대한 코딩만 하게 한다. 주로 게임엔진(프레임 워크)
	private int deptno = 0;//묵시적으로 private를 준다.|상속관계에 있어도 나만 볼수 있다.(접근 제한자)
	private String dname = null;//class는 선언시 초기값은 null이다.
	private String loc   = null;//null의 의미는 완성이 되지않은 실체가 없는 상태를 의미한다.
	public DeptVO() {}
	public DeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

}
