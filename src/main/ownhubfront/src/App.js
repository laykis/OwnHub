import './App.css';
import Login from "./Login";
import MainPage from './Main1';
import {useEffect, useState} from "react";
import { BrowserRouter, Route, Link, Router } from "react-router-dom";


function App() {
  // 로그인 상태 관리
  const [isLogin, setIsLogin] = useState(false)
 
  useEffect(() => {
    if(sessionStorage.getItem('user_id') === null){
    // sessionStorage 에 user_id 라는 key 값으로 저장된 값이 없다면
      console.log('isLogin ?? :: ', isLogin)
    } else {
    // sessionStorage 에 user_id 라는 key 값으로 저장된 값이 있다면
    // 로그인 상태 변경
      setIsLogin(true)
      console.log('isLogin ?? :: ', isLogin)
    }
  })


  return (
    <div className="App">
      <Router>
        {/* {isLogin ? 
          // Main 컴포넌트 호출 시 isLogin 이라는 props 값을 전달
          <Main isLogin={isLogin} /> : 
          <Login />
        } */}
        <Route path='/main1' componet={MainPage}/>
        <Route path='/' component={Login}/>
      </Router>
    </div>
  );
}

export default App;
