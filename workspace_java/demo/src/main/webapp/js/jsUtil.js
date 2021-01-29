function getText(el){
	      var text="";
	      if(el!=null){
	         if(el.childNodes){
	            for(var i=0;i<el.childNodes.length;i++){
	               var childNode = el.childNodes[i];
	               //너 텍스트 노드니?
	               if(childNode.nodeValue !=null){
	                  text = text+childNode.nodeValue;//100이 text에 담긴다
	               }      
	            }
	         }
	      }
	      return text;
	   }
	   //기존 TextNode의 값을 다른 문자열로 바꾸기
	   /***********************************************
	   param1 :document.getElementById("boardSold")
	   param2 :xhrObject. 
	   ************************************************/
	   function replaceText(el, value){ /*  */
	      if(el !=null){
	         clearText(el);//기존에 있던 10을 지워주세요.
	         //새로운 텍스트 노드 15를 생성하기
	         var newNode = document.createTextNode(value);//15
	         //위에서 생성한 텍스트 노드 값을 el에 붙이는 함수 호출하기
	         el.appendChild(newNode);
	      }
	   }
	   //기존 태그안에 문자열 지우는 함수 구현
	   function clearText(el){
	      if(el !=null){
	         if(el.childNodes){
	            for(var i=0;i<el.childNodes.length;i++){
	               var childNode = el.childNodes[i];
	               el.removeChild(childNode);
	            }
	         }
	      }
	   }
		function getBoardSold(){
			var boardSoldEL = document.getElementById("boardSold");
			var u_boardSold = getText(boardSoldEL);
			var costEL = document.getElementById("cost");//구매가를 감싸고 있는 span태그의 주소번지 담기
			var u_cost = getText(costEL);//구매가를 담을 변수 선언
			console.log('구매가'+u_cost);//로그 출력
			var priceEL = document.getElementById("price");//구매가를 감싸고 있는 span태그의 주소번지 담기
			var u_price = getText(priceEL);//소비자가를 담을 변수 선언
			console.log('소비자가'+u_price);//로그 출력
			var cashEL = document.getElementById("cash");//구매가를 감싸고 있는 span태그의 주소번지 담기
			var u_cash  = (u_price-u_cost)*u_boardSold; //마진금액을 담을 변수
			console.log('마진금액'+u_cash);//로그 출력
			replaceText(cashEL , u_cash);//replaceText()메소드를 가져와서 마진금액을 변환해줌
		}