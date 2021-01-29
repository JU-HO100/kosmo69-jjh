import React from 'react';
import ReactDOM from 'react-dom';

//클래스 생성 및 선언
//가상 돔을 구성하기 - 필요한 곳에 미리 랜더링(메모리)하였다가 출력이 나갈 때 결합시킴
//React.Component상속 받기 - 객체 생성
//안드로이드 class MainActivity extends AppCompatActivity상속
//class A extends Object
//코드블럭을 재사용할 수 있도록 기회를 제공
//클래스 내부에는 render라는 함수를 정의해서 화면에 출력될 내용을 만듬
//안드로이드에서도 라이프 사이클이 제공되고 있다.
//onCreate - onStart - onResume - onStop - [상태정보 수정메소드] - onDestroy
//리액트도 상태코드를 관리하고 삽입되는 시점이나 위치에 대한 작업이 필요하다.

class MainPage extends React.Component{
    render(){
        return <div className="intro">INTRO페이지</div>
    }
}
//리액트돔 즉 가상의 돔이 render콜백함수를 호출
//@param1 - 리액트의 클래스 이름
//@param2 - 위치를 지정해준다.
ReactDOM.render(<MainPage/>,document.getElementById('root')); //root가 있는 페이지에 MainPage를 출력해 주세요.
