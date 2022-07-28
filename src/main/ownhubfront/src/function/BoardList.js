import React, {useEffect, useState} from "react";
import axios from "axios";
import "../App.css";

function BoardList() {

    const [contentList, setContentList] = useState({})

    const handleContentList = (e) => {
        setContentList(e.target.value)
    }

    const printContentList = () => {
        return(
            <div>
                <table>
                    <tr>{contentList[0].title}</tr>
                </table>
            </div>
        );
    }

    useEffect(()=> {
            axios.get("/home/board/content")
                .then(res => handleContentList(res))
                .catch()
        },[]
    )

    return(
        <div>
            {printContentList()}
        </div>

    )
}

export default BoardList;