import React from "react";
// import axios from "axios";
import "../each_page.css";
import Sidebar from "../layout/sidebar_git";


const Git_main = () => {

    return (
        <div>
            <Sidebar/>
            <form id="search">
                <input id="search_input" name="keyword" placeholder="Search repository"></input> 
                <button id="btn_search">search</button>
            </form>
            <div id='git'>
                <h2>Repository 둘러보기</h2>
                <p>Group repository</p>
                <p>Dohyun's Repository</p>
                <p>Gayoung's Repository</p>
                <p>Yunji's Repository</p>
            </div>
        </div>
    )
}

export default Git_main