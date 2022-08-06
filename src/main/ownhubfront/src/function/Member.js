import React, {useState, useEffect} from "react";
import axios from "axios";
import "../each_page.css";
import Sidebar from "../layout/sidebar_member";

const Member = () => {
    const [users, setUsers] = useState({})
    const userInfo = (e) => {
        setUsers(e.target.value)
    }

    useEffect(()=>{
        axios.get("/mypage")
            .then(res => userInfo(res))
            .catch()
    }, []
    )

    function myInfo({users}){
        return (
            <div>
                <div id="info">
                    <img id="face" src={require("../layout/img/face.png")}></img>
                    <p id="name">김가영</p>
                    <p id="team_role">OwnHub - IT개발본부 - 차세대 개발팀</p>
                    <a href="/git/mygit"><button>Repository 이동하기</button></a>
                    <button>우편함</button>
                </div>
            </div>);
    };

    return (
        <div>
            <Sidebar/>
            
            <form id="search">
                <input id="search_input" name="keyword" placeholder="사원 검색"></input> 
                <button id="btn_search">search</button>
            </form>
        </div>
    )
}

export default Member