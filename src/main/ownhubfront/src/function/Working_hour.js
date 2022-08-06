import React, {useState} from "react";
// import axios from "axios";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "../each_page.css";
import Sidebar from "../layout/sidebar_working";

const Record = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [endDate,setEndDate] = useState(new Date());

    return (
        <div>
            <Sidebar/>
            <body id="body">
                <div id="vacation">
                    <h2>휴가 신청</h2>
                    <div>
                        <p>휴가일자</p>
                        <DatePicker selected={startDate} onChange={date => setStartDate(date)} />
                        <DatePicker selected={endDate} onChange={date => setEndDate(date)}/>
                    </div>
                    <div>
                        <p>휴가종류</p>
                        <select id="cboard">
                            <option value="choice">(선택)</option>
                            <option value="full">연차</option>
                            <option value="half">반차</option>
                        </select>
                    </div>
                    <div>
                        <p>사유</p>
                        <input id = "reason" type="text" name="title" placeholder="사유를 작성해주세요" />
                    </div>
                    <button type="button" id="submitBtn">기안</button>
                </div>
            </body>
        </div>
    )
}

export default Record