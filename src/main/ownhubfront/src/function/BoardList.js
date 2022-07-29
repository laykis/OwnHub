import React, {useEffect, useState} from "react";
import axios from "axios";
import "../App.css";

function BoardList() {

    const [contentList, setContentList] = useState({})

    const handleContentList = (e) => {
        setContentList(e.target.value)
    }



    useEffect(()=> {
            axios.get("/home/board/content")
                .then(res => handleContentList(res))
                .catch()
        },[]
    )

    const printContentList = () => {
        return(
            <div>
                {contentList.map((content) =>{
                    return <div> title = {content.title} </div>
                })}
            </div>
        );
    };

    return(
        <div>
            {printContentList}
        </div>

    )
}

export default BoardList;