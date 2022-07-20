import React, {useEffect, useState} from "react";
import axios from "axios";
import "../App.css";


//userId, userPw로 보내지도록 해야함
function Login() {
    const [userId, setUserID] = useState("")
    const [userPw, setUserPw] = useState("")

    // input data의 변화가 있을 때마다 value 값을 변경해서 useState해준다
    const handleUserId = (e) => {
        setUserID(e.target.value)
    }

    const handleUserPw = (e) => {
        setUserPw(e.target.value)
    }


    //Login 버튼 클릭 이벤트
    const onClickLogin = () => {
        console.log('click login')
        console.log('ID : ', userId)
        console.log('PW : ', userPw)

        axios.post('/user/loginpro', null, {
            params: {
            'userId': userId,
            'userPw': userPw
            }
        })
        .then(res => {
            console.log(res)
            console.log('res.data.userId :: ', res.data.userId)
            console.log('res.data.msg :: ', res.data.msg)
            if(res.data.userId === 'undefined'){
                // id 일치하지 않는 경우 userId = undefined, msg = '입력하신 id 가 일치하지 않습니다.'
                console.log('======================',res.data.msg)
                alert('입력하신 id 가 일치하지 않습니다.')
            } else if(res.data.userId === null){
                // id는 있지만, pw 는 다른 경우 userId = null , msg = undefined
                console.log('======================','입력하신 비밀번호 가 일치하지 않습니다.')
                alert('입력하신 비밀번호 가 일치하지 않습니다.')
            } else if(res.data.userId === userId) {
                // id, pw 모두 일치 userId = userId1, msg = undefined
                console.log('======================','로그인 성공')
                window.location.href = '/main1'
            }

        })
        .catch()
    }

    // 페이지 랜더링 후 가장 처음 호출되는 함수
    useEffect(()=> {
        axios.get("/user/login")
            .then(res => console.log(res))
            .catch()
    },[]
    )


    return(
        <div>
            <body>
                <div class="wrap-login">
                    <section class="login-section">
                        <h1 class="logo">Ownhub Login</h1>
                        <form class="login-form">
                            <div class="input-box">
                                <input id="inputId" type="text" name='userId' value={userId} onChange={handleUserId} placeholder="전화번호, 사용자 이름 또는 이메일" />
                                <input id="inputPw" type="password" name='userPw' value={userPw} onChange={handleUserPw} placeholder="비밀번호" />
                            </div>
                            <a href="/main1"><button type='button' id="loginBtn" onClick={onClickLogin} class="btn primary">로그인</button></a>
                            <br/>
                            <a class="form-end" href="$">비밀번호를 잊으셨나요?</a>
                        </form>
                    </section>
                </div>
            </body>
        </div>

    )
}

export default Login;