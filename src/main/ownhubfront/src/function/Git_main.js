import React from "react";
// import axios from "axios";
import "../each_page.css";


const Git_main = () => {

    return (
        <div>
            <form id="search">
                <input id="search_input" name="keyword" placeholder="Search repository"></input> 
                <button>search</button>
            </form>
            <h2>Repository 둘러보기</h2>
            <div id='card_section'>
                <p>Group repository</p>
                <p>Dohyun's Repository</p>
                <p>Gayoung's Repository</p>
                <p>Yunji's Repository</p>
            </div>
        </div>
    )
}

export default Git_main