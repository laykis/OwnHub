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

    function Content({content}){
        return(
            <div>
                {content.title}
            </div>
        )
    }
    function printContentList({contentList}){
        return(
            <div>
                {contentList.map(content => (
                    <Content title = {content} />
                ))}
            </div>
        );
    };

    return(
        <div>
            {printContentList(contentList)}
        </div>

    )
}

export default BoardList;