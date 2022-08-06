import React, {useState} from "react";
// import axios from "axios";
import DatePicker from "react-datepicker";
import "../each_page.css";
import Sidebar from "../layout/sidebar_working";

const Vacation = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [endDate,setEndDate] = useState(new Date());

    return (
        <div>
            <Sidebar/>
            <div id="vacation">
                <h2>휴가 신청</h2>
                <div>
                    <h3>휴가일자</h3>
                    <table border={1}>
                        <tr>
                            <td>휴가 시작일</td>
                            <td><DatePicker selected={startDate} onChange={date => setStartDate(date)} /></td>
                        </tr>
                        <tr>
                            <td>휴가 종료일</td>
                            <td><DatePicker selected={endDate} onChange={date => setEndDate(date)}/></td>
                        </tr>
                    </table>
                </div>
                <div>
                    <h3>휴가종류</h3>
                    <select id="vacation_type">
                        <option value="choice">(선택)</option>
                        <option value="full">연차</option>
                        <option value="half">반차</option>
                    </select>
                </div>
                <div>
                    <h3>사유</h3>
                    <input id = "reason" type="text" name="title" placeholder="사유를 작성해주세요" />
                </div>
                <button type="button" id="submitBtn">기안</button>
            </div>
        </div>
    )
}

export default Vacation