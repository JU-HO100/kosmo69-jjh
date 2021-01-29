package bookingmovie2;


public class MovieMemberVO {
	   	//Customer Table
	    private String cus_id      		= null;       
	    private String cus_pw      		= null;       
	    private String cus_name    	= null;       
	    private String cus_tel     		= null;       
	    private String cus_booknum 	= null;       
	   
	    //Movie Table	    
	    private String m_code       	= null;        
	    private String title        		= null;        
	    private String genre        		= null;        
	    private String director     		= null;        
	    private String actor        		= null;        
	    private String running_time 	= null;        
	    private String story        		= null;
	    private String t_booknum       		= null;
	    
		public MovieMemberVO (){}
		public MovieMemberVO (
				String cus_id      
				,String cus_pw      
				,String cus_name    
				,String cus_tel     
				,String cus_booknum 
				
				,String m_code      
				,String title       
				,String genre       
				,String director    
				,String actor       
				,String running_time
				,String story 
				,String t_booknum
				) {
			this.cus_id           			=   	cus_id      			;
			this.cus_pw           			=   	cus_pw      		;
			this.cus_name         			=   	cus_name    		;
			this.cus_tel          			=   	cus_tel     			;
			this.cus_booknum      		=   	cus_booknum 	;
			
			this.m_code           			=   	m_code      		;
			this.title            				=   	title       			;
			this.genre            			=   	genre       			;
			this.director         			=   	director    			;
			this.actor            			=   	actor       			;
			this.running_time     		=   	running_time		;
			this.story            			=   	story       			;
			this. t_booknum            		=   	t_booknum     			;
		}
	    //Getter, Setter
		public String getCus_id() {
			return cus_id;
		}
		public void setCus_id(String cus_id) {
			this.cus_id = cus_id;
		}
		public String getCus_pw() {
			return cus_pw;
		}
		public void setCus_pw(String cus_pw) {
			this.cus_pw = cus_pw;
		}
		public String getCus_name() {
			return cus_name;
		}
		public void setCus_name(String cus_name) {
			this.cus_name = cus_name;
		}
		public String getCus_tel() {
			return cus_tel;
		}
		public void setCus_tel(String cus_tel) {
			this.cus_tel = cus_tel;
		}
		public String getCus_booknum() {
			return cus_booknum;
		}
		public void setCus_booknum(String cus_booknum) {
			this.cus_booknum = cus_booknum;
		}
		public String getM_code() {
			return m_code;
		}
		public void setM_code(String m_code) {
			this.m_code = m_code;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public String getActor() {
			return actor;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}
		public String getRunning_time() {
			return running_time;
		}
		public void setRunning_time(String running_time) {
			this.running_time = running_time;
		}
		public String getStory() {
			return story;
		}
		public void setStory(String story) {
			this.story = story;
		}
		public String getT_Booknum() {
			return t_booknum;
		}
		public void setT_Booknum(String t_booknum) {
			this.t_booknum = t_booknum;
		}
}