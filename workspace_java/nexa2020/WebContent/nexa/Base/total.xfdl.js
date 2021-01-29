(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("total");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1850,1200);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Edit("Edit00","10","608","394","225",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit01","34","626","340","154",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            this.addChild(obj.name, obj);

            obj = new TextArea("TextArea00_00","144","706","200","35",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","94","706","50","35",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("PW");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","95","666","50","35",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("ID");
            this.addChild(obj.name, obj);

            obj = new TextArea("t_lid","144","666","200","35",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            this.addChild(obj.name, obj);

            obj = new Button("btn_singup","153","791","70","30",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("회원가입");
            this.addChild(obj.name, obj);

            obj = new Button("btn_login","228","791","70","30",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("로그인");
            this.addChild(obj.name, obj);

            obj = new Button("btn_cancel","304","791","70","30",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("취소");
            this.addChild(obj.name, obj);

            obj = new Div("Div00","867","30","954","657",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("Div00");
            obj.set_background("bisque");
            this.addChild(obj.name, obj);

            obj = new Button("btn_mlogin","864","6","83","28",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_text("로그인");
            this.Div00.addChild(obj.name, obj);

            obj = new Div("Div01","122","77","689","570",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_text("Div01");
            obj.set_background("aquamarine");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btn_listsearch","613","500","68","32",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("0");
            obj.set_text("검색");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Combo("Combo00","4","500","87","32",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("1");
            obj.set_text("제목");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new TextArea("TextArea00","92","500","521","32",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("2");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_new","594","532","87","30",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("3");
            obj.set_text("글쓰기");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_1","207","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("4");
            obj.set_text("1");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_2","227","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("5");
            obj.set_text("2");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_3","245","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("6");
            obj.set_text("3");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_4","265","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("7");
            obj.set_text("4");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_5","285","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("8");
            obj.set_text("5");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_6","305","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("9");
            obj.set_text("6");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_8","345","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("10");
            obj.set_text("8");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_7","325","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("11");
            obj.set_text("7");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Button("btn_9","365","536","15","22",null,null,null,null,null,null,this.Div00.form.Div01.form);
            obj.set_taborder("12");
            obj.set_text("9");
            this.Div00.form.Div01.addChild(obj.name, obj);

            obj = new Grid("m_page","128","82","677","490",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("2");
            obj.set_binddataset("t_colum");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"100\"/><Column size=\"290\"/><Column size=\"155\"/><Column size=\"50\"/><Column size=\"80\"/></Columns><Rows><Row size=\"25\" band=\"head\"/><Row size=\"23\"/></Rows><Band id=\"head\"><Cell text=\"글번호\"/><Cell col=\"1\" text=\"글제목\"/><Cell col=\"2\" text=\"날짜\"/><Cell col=\"3\" text=\"조회수\"/><Cell col=\"4\" text=\"작성자\"/></Band><Band id=\"body\"><Cell text=\"bind:글번호\"/><Cell col=\"1\" text=\"bind:글제목\"/><Cell col=\"2\" text=\"bind:날짜\"/><Cell col=\"3\" text=\"bind:조회수\"/><Cell col=\"4\" text=\"bind:작성자\"/></Band></Format></Formats>");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btn_free","16","37","151","35",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("3");
            obj.set_text("자유게시판");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btn_server","167","37","151","35",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("4");
            obj.set_text("서버");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btn_client","318","37","151","35",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("5");
            obj.set_text("클라이언트");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static00","16","7","500","30",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("6");
            obj.set_text("가짜 홈페이지 게시판");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit00_00","30","30","800","549",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            this.addChild(obj.name, obj);

            obj = new Button("btn_singup2","339","460","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_text("회원가입");
            this.addChild(obj.name, obj);

            obj = new Button("btn_cell","441","460","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            obj.set_text("취소");
            this.addChild(obj.name, obj);

            obj = new TextArea("t_sid","299","114","201","40",null,null,null,null,null,null,this);
            obj.set_taborder("13");
            this.addChild(obj.name, obj);

            obj = new TextArea("t_spw","300","170","201","40",null,null,null,null,null,null,this);
            obj.set_taborder("14");
            this.addChild(obj.name, obj);

            obj = new TextArea("t_spw2","299","220","201","40",null,null,null,null,null,null,this);
            obj.set_taborder("15");
            this.addChild(obj.name, obj);

            obj = new TextArea("t_name","299","270","201","40",null,null,null,null,null,null,this);
            obj.set_taborder("16");
            this.addChild(obj.name, obj);

            obj = new TextArea("t_pn","299","319","201","40",null,null,null,null,null,null,this);
            obj.set_taborder("17");
            this.addChild(obj.name, obj);

            obj = new TextArea("t_zip","300","370","301","40",null,null,null,null,null,null,this);
            obj.set_taborder("18");
            this.addChild(obj.name, obj);

            obj = new Button("btn_idcheck","540","114","80","35",null,null,null,null,null,null,this);
            obj.set_taborder("19");
            obj.set_text("중복확인");
            this.addChild(obj.name, obj);

            obj = new Button("btn_zipsearch","631","370","80","40",null,null,null,null,null,null,this);
            obj.set_taborder("20");
            obj.set_text("주소찾기");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00","241","113","60","41",null,null,null,null,null,null,this);
            obj.set_taborder("21");
            obj.set_text("ID");
            this.addChild(obj.name, obj);

            obj = new Static("Static01_00","239","170","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("22");
            obj.set_text("PW");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","239","219","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("23");
            obj.set_text("PW확인");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","241","269","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("24");
            obj.set_text("이름");
            this.addChild(obj.name, obj);

            obj = new Static("Static04","239","319","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("25");
            obj.set_text("PH");
            this.addChild(obj.name, obj);

            obj = new Static("Static05","239","370","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("26");
            obj.set_text("주소");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1850,1200,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script

        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.TextArea00_00.addEventHandler("onchanged",this.TextArea00_00_onchanged,this);
            this.Div00.form.btn_mlogin.addEventHandler("onclick",this.Div00_Button00_onclick,this);
            this.Div00.form.Div01.addEventHandler("onclick",this.Div00_Div01_onclick,this);
            this.Div00.form.Div01.form.TextArea00.addEventHandler("onchanged",this.Div00_Div01_TextArea00_onchanged,this);
            this.Div00.form.Div01.form.btn_new.addEventHandler("onclick",this.Div00_Div01_Button01_onclick,this);
            this.Div00.form.btn_free.addEventHandler("onclick",this.Div00_Button01_onclick,this);
            this.Div00.form.btn_server.addEventHandler("onclick",this.Div00_Button01_onclick,this);
            this.Div00.form.btn_client.addEventHandler("onclick",this.Div00_Button01_onclick,this);
            this.Div00.form.Static00.addEventHandler("onclick",this.Div00_Static00_onclick,this);
            this.Static03.addEventHandler("onclick",this.Static03_onclick,this);
        };

        this.loadIncludeScript("total.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
