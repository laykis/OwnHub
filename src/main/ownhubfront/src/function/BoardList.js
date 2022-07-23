import React, {useEffect} from "react";
import axios from "axios";
import "../App.css";

function BoardList() {

    let contentList

    useEffect(()=> {
            axios.get("/home/board/content")
                .then(res => console.log(res))
                .catch()
        },[]
    )

    return(
        <div>
            <h1>Board List</h1>
            {contentList.map(contentL => (
                <BoardList number = {contentL.id} title = {contentL.title} content = {contentL.content}/>
            ))}
        </div>
    )
}

export default BoardList;