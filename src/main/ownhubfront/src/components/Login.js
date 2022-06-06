import React, {useEffect, useState} from "react";
import axios from "axios";

//userId, userPw로 보내지도록 해야함

function Login() {


    const [userId, setInputID] = useState("")
    const [userPw, setInputPw] = useState("")

    // input data의 변화가 있을 때마다 value 값을 변경해서 useState해준다
    const handleInputId = (e) => {
        setInputID(e.target.value)
    }

    const handleInputPw = (e) => {
        setInputPw(e.target.value)
    }

    //Login 버튼 클릭 이벤트
    const onClickLogin = () => {
        console.log('click login')
    }

    // 페이지 랜더링 후 가장 처음 호출되는 함수
    useEffect(()=> {
        axios.get("/user/login") // 이 부분 axios로 가져오는 걸로 바꿔주세요!!!!!!!!!!!!!!!!
        .then(res => console.log(res))
        .catch()
    },
    // 페이지 호출 후 처음 한번만 호출될 수 있도록 [] 추가
    []
    )

    return(
        <div>
            <h2>Login</h2>
            <div>
                <label htmlFor='user_id'>ID : </label>
                <input type='text' name='user_id' value={userId} onChange={handleInputId}/>
            </div>
            <div>
                <label htmlFor='user_pw'>PW : </label>
                <input type='password' name='user_pw' value={userPw} onChange={handleInputPw}/>
            </div>
            <div>
                <button type="button" onClick={onClickLogin}>Login</button>
            </div>
        </div>
    )
}

export default Login;