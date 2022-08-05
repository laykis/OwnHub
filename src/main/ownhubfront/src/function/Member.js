import React from "react";
// import axios from "axios";
import "../each_page.css";
import Sidebar from "../layout/sidebar_member";

const Member = () => {
    return (
        <div>
            <Sidebar/>
            
            <form id="search">
                <input id="search_input" name="keyword" placeholder="사원 검색"></input> 
                <button>search</button>
            </form>
        </div>
    )
}

export default Member