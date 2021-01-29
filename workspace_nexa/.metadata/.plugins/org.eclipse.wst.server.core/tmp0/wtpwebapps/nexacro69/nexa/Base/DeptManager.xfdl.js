(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("DeptManager");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_dept", this);
            obj._setContents("<ColumnInfo><Column id=\"deptno\" type=\"INT\" size=\"10\"/><Column id=\"dname\" type=\"STRING\" size=\"100\"/><Column id=\"loc\" type=\"STRING\" size=\"50\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","55","20","120","34",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("부서관리");
            obj.set_font("20px/normal \"Gulim\"");
            this.addChild(obj.name, obj);

            obj = new Grid("gr_dept","55","110","495","270",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_binddataset("ds_dept");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row band=\"head\" size=\"24\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"부서번호\"/><Cell col=\"1\" text=\"부서명\"/><Cell col=\"2\" text=\"지역\"/></Band><Band id=\"body\"><Cell text=\"bind:deptno\"/><Cell col=\"1\" text=\"bind:dname\"/><Cell col=\"2\" text=\"bind:loc\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("btn_sel","55","60","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("조회");
            this.addChild(obj.name, obj);

            obj = new Button("btn_ins","125","60","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("입력");
            this.addChild(obj.name, obj);

            obj = new Button("btn_upd","190","60","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("수정");
            this.addChild(obj.name, obj);

            obj = new Button("btn_del","260","60","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("삭제");
            this.addChild(obj.name, obj);

            obj = new Button("btn_modal","330","60","60","40",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("모달");
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
        this.registerScript("DeptManager.xfdl", function() {

        this.Static00_onclick = function(obj,e)
        {
        	var id = "deptList";
        	var url = "SvcURL::/deptXML.kosmo";
        	var reqDs = "";
        	var respDs = "ds_dept = out_dept";
        	var args = "";
        	var callback = "received";

        	this.transaction(id, url, reqDs, respDs, args, callback);
        };
        this.received = function(svcID, errCD, errMSG){
        	alert("received 콜백함수 호출"+svcID+","+errMSG);
        	if(errCD < 0){
        		this.alert("Error : " +errMSG);
        		//return;//함수 탈출
        	}
        	if(svcID == "deptList"){
        			this.alert("조회 콜백 호출"+this.ds_dept.getColumnInfo(1));
        	}
        }

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {

        };

        this.loadIncludeScript("DeptManager.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
