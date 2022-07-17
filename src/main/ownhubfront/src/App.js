import "./App.css";
import { useEffect, useState } from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";

import Login from "./function/Login";
import MainPage from "./function/Main1";
import Layout from "./layout/layout";
import Footer from "./layout/footer";
import Header from "./layout/header";

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
    <>
      <Header />
      {/* <Layout> */}
      <BrowserRouter>
        <div id="center">
          <Switch>
            <Route path={"/main1"} component={MainPage} />
            <Route path={"/"} component={Login} />
          </Switch>
        </div>
      </BrowserRouter>
      {/* </Layout> */}
      <Footer />
    </>
  );
}

export default App;
