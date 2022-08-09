import React, { useState } from "react";
import axios from "axios";
import "../each_page.css";
import Sidebar from "../layout/sidebar_git";


const Git_main = () => {

    // Repository 검색 
    const [search, searchRepo] = useState('');

    const handleSearch = (e) => {
        searchRepo(e.target.value)
    }

    const onSearch = () => {
        e.preventDefault();
        console.log(search + " 찾기")
        axios.post("/repo/search", null, {
            param : { "search" : search}
        })
            .then(res => {
                if(res.data.result === "success"){
                    console.log(search + " 찾음")
                    window.location.href ="redirect:/teamgit"
                }
            })
            .catch()
    }; 

    // 검색한 Repository 보여주기 



    return (
        <div>
            <Sidebar/>
            <div id='git'>
                <h2>Repository 둘러보기</h2>
                <form id="search" onSubmit={onSearch}>
                    <input id="search_input" name="keyword" value={search} onChange={handleSearch} placeholder="Search repository"></input> 
                    <button id="btn_search">search</button>
                </form>
                <div>
                    
                </div>
            </div>
        </div>
    )
}

export default Git_main