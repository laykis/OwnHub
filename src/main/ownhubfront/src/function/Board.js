import React, {useState} from "react";
import axios from "axios";
import Sidebar from "../layout/sidebar_board";
import "../each_page.css";

function Board() {
    const [title, setTitle] = useState("")
    const [content, setContent] = useState("")
    const [cboard, setSelected] = useState("")

    const handleTitle = (e) => {
        setTitle(e.target.value)
    }

    const handleContent = (e) => {
        setContent(e.target.value)
    }

    const handleSelect = (e) => {
        setSelected(e.target.value)
    }

    const onClickSubmit = () =>{
        console.log("click submit")
        console.log("title =", title)
        console.log("content =", content)
        console.log("type =", cboard)

        axios.post("/main/board/submit", null, {
            param: {
                "title" : title,
                "content" : content,
                "cboard" : cboard
            }
        })
            .then(res => {
                console.log(res)
                if(res.data.result === "sucsess"){
                    console.log("content post sucsess")
                    alert("게시 완료")
                    window.location.href = "redirect:/content"
                }
            })
            .catch()

    }


    return (
        <div>
            <body>
                <Sidebar/>
                <h2 id="title_page">글쓰기</h2>
                <div id="writing">
                    <div>
                        <select id="cboard" value={cboard} onChange={handleSelect}>
                            <option value="notice">공지사항</option>
                            <option value="team">부서게시판</option>
                            <option value="free">자유게시판</option>
                        </select>
                        <input id = "writing_title" type="text" name="title" value={title} onChange={handleTitle} placeholder="제목을 입력하세요." />
                    </div>
                    <div>
                        <input id = "writing_content" type="text" name="content" value={content} onChange={handleContent} placeholder="내용을 입력하세요." />
                    </div>
                    <div>
                    <button type="button" id="submitBtn" onClick={onClickSubmit}>글 올리기</button>
                    </div>
                </div>
            </body>
        </div>
    )

}
export default Board;