import React from "react";
// import axios from "axios";
import "../each_page.css";
import Sidebar from "../layout/sidebar_git";


const Git_my = () => {

    return (
        <div>
            <Sidebar/>
            <form id="search">
                <input id="search_input" name="keyword" placeholder="Search repository"></input> 
                <button id="btn_search">search</button>
            </form>
            <div id="git">
                <h2 id='page_title'>나의 Git</h2>
                <div id='button_section'>
                    <button>Repository 생성</button>
                    <button>커밋하기</button>
                </div>
            </div>
        </div>
    )
}

export default Git_my