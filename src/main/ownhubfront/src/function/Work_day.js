import React, {useState} from "react";
// import axios from "axios";
import "../each_page.css";

const Workday = () => {
    return (
        <div>
            <div id="vacation">
                <h2>휴가 신청</h2>
                <div>
                    <select id="cboard">
                        <option value="choice">(선택)</option>
                        <option value="full">연차</option>
                        <option value="half">반차</option>
                    </select>
                </div>
                <div>
                    <input id = "title" type="text" name="title" value={title} onChange={handleTitle} placeholder="제목을 입력하세요." />
                </div>
                <div>
                    <input id = "content" type="text" name="content" value={content} onChange={handleContent} placeholder="내용을 입력하세요." />
                </div>
                <button type="button" id="submitBtn" onClick={onClickSubmit}>신청</button>
            </div>
        </div>
    )
}

export default Workday