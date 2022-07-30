import React, {useEffect, useState} from "react";
import axios from "axios";
import "../each_page.css";

function Board() {

    const [title, setTitle] = useState("")
    const [content, setContent] = useState("")

    const handleTitle = (e) => {
        setTitle(e.target.value)
    }

    const handleContent = (e) => {
        setContent(e.target.value)
    }

    const onClickSubmit = () =>{
        console.log("click submit")
        console.log("title =", title)
        console.log("content =", content)

        axios.post("/main/board/submit", null, {
            param: {
                "title" : title,
                "content" : content
            }
        })
            .then(res => {
                console.log(res)
                if(res.data.result === "sucsess"){
                    console.log("content post sucsess")
                    alert("게시 완료")
                    window.location.href = "redirect:/main/board"
                }
            })
            .catch()

    }


    return (
        <div id="writing">
            <body>
                <div>
                    <form>
                        <div>
                            <select id="cboard">
                                <option value="notice">공지사항</option>
                                <option value="team">부서게시판</option>
                                <option value="free">자유게시판</option>
                            </select>
                        </div>
                        <div>
                            <input id = "title" type="text" name="title" value={title} onChange={handleTitle} placeholder="제목을 입력하세요." />
                        </div>
                        <div>
                            <input id = "content" type="text" name="content" value={content} onChange={handleContent} placeholder="내용을 입력하세요." />
                        </div>
                        <button type="button" id="submitBtn" onClick={onClickSubmit}>작성</button>
                    </form>
                </div>
            </body>
        </div>
    )

}
export default Board;