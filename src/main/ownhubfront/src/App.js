import "./App.css";
import { useEffect, useState } from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";

import Layout from "./layout/layout";
import Footer from "./layout/footer";
import Header from "./layout/header";

import Login from "./function/Login";
import MainPage from "./function/Main1";
import SignUp from "./function/Signup";

import Board from "./function/Board";
import BoardList from "./function/BoardList";

import Git_main from "./function/Git_main";
import Git_my from "./function/Git_my";

import Member from "./function/Member";
import Mypage from "./function/Mypage";
import Management from "./function/Management";

import Vacation from "./function/Working_vacation";
import Workday from "./function/Working_Monthly";



function App() {
  // 로그인 상태 관리
  const [isLogin, setIsLogin] = useState(false);

  useEffect(() => {
    if (sessionStorage.getItem("user_id") === null) {
      // sessionStorage 에 user_id 라는 key 값으로 저장된 값이 없다면
      console.log("isLogin ?? :: ", isLogin);
    } else {
      // sessionStorage 에 user_id 라는 key 값으로 저장된 값이 있다면
      // 로그인 상태 변경
      setIsLogin(true);
      console.log("isLogin ?? :: ", isLogin);
    }
    //eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <div>
      <Header />
      <BrowserRouter>
        <Switch>

          {/* Git */}
          <Route path="/git/mygit" component={Git_my}/>
          <Route path="/git/teamgit" component={Git_main}/>
          
          {/* 사원관리 */}
          <Route path="/members" component={Member}/>
          <Route path="/mypage" component={Mypage}/>
          <Route path="/management" component={Management}/>

          {/* 근태관리 */}
          <Route path="/working/vacation" component={Vacation}/>
          <Route path="/working/monthly" component={Workday}/>
          
          {/* 게시판 */}
          <Route path="/board" component={Board}/>
          <Route path="/content" component={BoardList}/>
          
          {/* 메인 페이지 */}
          <Route path="/main1" component={MainPage} />
          <Route path="/login" component={Login} />
          <Route path="/signup" component={SignUp}/>
          <Route path="/" exact component={Layout}/>

        </Switch>
      </BrowserRouter>
      <Footer />
    </div>
  );
}

export default App;
