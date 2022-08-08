import "../App.css";
import React, { useEffect, useState } from "react";
import axios from "axios";

const Signup = () =>{
  const [id,setId] = useState('');
  const [name,setName] = useState('');
  const [password,setPassword] = useState('');
  const [passwordCheck,setPasswordCheck] = useState('');
  const [passwordError,setPasswordError] = useState(false);
  const [email, setEmail] = useState('');
  const [team, setTeam] = useState('');
  const [role, setRole] = useState('');

  const onSubmit = (e) => {
      e.preventDefault();
      if(password !== passwordCheck){
          return setPasswordError(true);
      }
      console.log({
          id,
          name,
          password,
          passwordCheck,
          email, 
          team,
          role
      });

      axios.post("/main/signup", null, {
        param: {
            "id" : id,
            "name" : name,
            "password" : password,
            "email" : email, 
            "team" : team,
            "role" : role
        }
    })
        .then(res => {
            console.log(res)
            if(res.data.result === "sucsess"){
                console.log("Signup success")
                alert("회원가입이 완료되었습니다. 로그인을 진행하세요")
                window.location.href = "redirect:/login"
            }
        })
        .catch()
  };

  // Coustom Hook 이전
  const onChangeId = (e) => {
    setId(e.target.value);
  };
  const onChangeName = (e) => {
    setName(e.target.value);
  };
  const onChangePassword = (e) => {
    setPassword(e.target.value);
  };
  const onChangePasswordChk = (e) => {
    //비밀번호를 입력할때마다 password 를 검증하는 함수
    setPasswordError(e.target.value !== password);
    setPasswordCheck(e.target.value);
  };
  const onChangeEmail = (e) => {
    setEmail(e.target.value);
  };
  const onChangeTeam = (e) => {
    setTeam(e.target.value);
  };
  const onChangeRole = (e) => {
    setRole(e.target.value);
  };

  return (
      <div class="wrap-signup">
        <form onSubmit={onSubmit} class="box-section">
            <div>
                <input id="signup_form" name="user-name" value={name} required onChange={onChangeName} placeholder='이름'></input><br/>
                <input id="signup_form" name="user-id" value={id} required onChange={onChangeId} placeholder="아이디"></input><br/>
                <input id="signup_form" name="user-password" type="password" value={password} required onChange={onChangePassword} placeholder="비밀번호" ></input><br/>
                <input id="signup_form" name="user-password-check" type="password" value={passwordCheck} required onChange={onChangePasswordChk} placeholder="비밀번호 확인"></input><br/>
                {passwordError && <div style={{color : 'red'}}>비밀번호가 일치하지 않습니다.</div>}
                <input id="signup_form" name="user-email" value={email} required onChange={onChangeEmail} placeholder="이메일"></input><br/>
                <input id="signup_form" name="user-team" value={team} required onChange={onChangeTeam} placeholder="소속부서"></input><br/>
                <input id="signup_form" name="user-role" value={role} required onChange={onChangeRole} placeholder="직급"></input>
            </div>
            <div style={{marginTop:10}}>
                <button id="submitBtn" type="primary" htmlType="submit" >가입하기</button>
            </div>
        </form>
      </div>
  );
};

export default Signup;
