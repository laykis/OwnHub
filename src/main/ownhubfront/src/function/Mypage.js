import React, {useState, useEffect} from "react";
import axios from "axios";
import "../each_page.css";
import Sidebar from "../layout/sidebar_member";

function Mypage() {
    const [users, setUsers] = useState(null)
    axios.get("url")

    {/*
    if(photos.length>0) {
        return 
    }*/}

    return (
        <div>
            <Sidebar/>
            <div id="info">
                <img id="face" src={require("../layout/img/face.png")}></img>
                <p id="name">김가영</p>
                <p id="team_role">OwnHub - IT개발본부 - 차세대 개발팀</p>
            </div>

        </div>
    )
}

export default Mypage