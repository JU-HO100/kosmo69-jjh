(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("empManager");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_emp", this);
            obj._setContents("<ColumnInfo><Column id=\"empno\" type=\"STRING\" size=\"256\"/><Column id=\"ename\" type=\"STRING\" size=\"256\"/><Column id=\"job\" type=\"STRING\" size=\"256\"/><Column id=\"mgr\" type=\"STRING\" size=\"256\"/><Column id=\"hiredate\" type=\"STRING\" size=\"256\"/><Column id=\"comm\" type=\"STRING\" size=\"256\"/><Column id=\"deptno\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"empno\">7566</Col><Col id=\"ename\">이순신</Col><Col id=\"job\">SALESMAN</Col><Col id=\"mgr\">8000</Col><Col id=\"hiredate\">2020-10-25</Col><Col id=\"comm\">3000</Col><Col id=\"deptno\">40</Col></Row><Row/></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_dept", this);
            obj._setContents("<ColumnInfo><Column id=\"deptno\" type=\"INT\" size=\"5\"/><Column id=\"dname\" type=\"STRING\" size=\"50\"/><Column id=\"loc\" type=\"STRING\" size=\"100\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Button("btn_search","170","60","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("조회");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","41","60","119","50",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","40","110","561","262",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_binddataset("ds_emp");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row band=\"head\" size=\"24\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"empno\"/><Cell col=\"1\" text=\"ename\"/><Cell col=\"2\" text=\"job\"/><Cell col=\"3\" text=\"mgr\"/><Cell col=\"4\" text=\"hiredate\"/><Cell col=\"5\" text=\"comm\"/><Cell col=\"6\" text=\"deptno\"/></Band><Band id=\"body\"><Cell text=\"bind:empno\"/><Cell col=\"1\" text=\"bind:ename\"/><Cell col=\"2\" text=\"bind:job\"/><Cell col=\"3\" text=\"bind:mgr\"/><Cell col=\"4\" text=\"bind:hiredate\"/><Cell col=\"5\" text=\"bind:comm\"/><Cell col=\"6\" text=\"bind:deptno\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid01","660","105","339","273",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_binddataset("ds_dept");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row band=\"head\" size=\"24\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"deptno\"/><Cell col=\"1\" text=\"dname\"/><Cell col=\"2\" text=\"loc\"/></Band><Band id=\"body\"><Cell text=\"bind:deptno\"/><Cell col=\"1\" text=\"bind:dname\"/><Cell col=\"2\" text=\"bind:loc\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","660","57","69","47",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Div("Div00","41","10","249","40",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("사원관리시스템 Ver1.0");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("empManager.xfdl", function() {

        this.btn_search_onclick = function(obj,e)
        {
        	alert("조회 호출 성공");
        	//this.transaction("empSearch","SvcURL::select_emp.jsp","in_emp=ds_emp","ds_emp=out_emp","","fn_callback");
        	this.transaction("empSearch","SvcURL::empManagerAction.do","in_emp=ds_emp","ds_emp=out_emp","","fn_callback");
        }

        this.fn_callback = function(svcID, errCD, errMSG){
        	alert("fn_callback 호출 :"+svcID+","+errCD+","+errMSG);
        }

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.btn_search.addEventHandler("onclick",this.btn_search_onclick,this);
        };

        this.loadIncludeScript("empManager.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
