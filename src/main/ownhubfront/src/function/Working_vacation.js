import React, {useState} from "react";
// import axios from "axios";
import DatePicker from "react-datepicker";
import "../each_page.css";
import Sidebar from "../layout/sidebar_working";

const Vacation = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [endDate,setEndDate] = useState(new Date());
    const [vacation_type, setSelected] = useState("")

    

    return (
        <div>
            <Sidebar/>
            <div id="vacation">
                <h2 id="vacation_title">휴가 신청</h2>
                <table id="vacation_table" border={0}>
                    <tr>
                        <td><h3>휴가일자</h3></td>
                        <td>휴가 시작일</td>
                        <td><DatePicker selected={startDate} onChange={date => setStartDate(date)} /></td>
                        <td>휴가 종료일</td>
                        <td><DatePicker selected={endDate} onChange={date => setEndDate(date)}/></td>
                    </tr>
                    <tr>
                        <td><h3>휴가종류</h3></td>
                        <td colSpan='4'>
                            <select id="vacation_type" value={vacation_type}>
                                <option value="choice">(선택)</option>
                                <option value="full">연차</option>
                                <option value="half">반차</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><h3>사유</h3></td>
                        <td colSpan='4'>
                            <input id = "reason" type="text" name="title" placeholder="사유를 작성해주세요" />
                        </td>
                    </tr>
                </table>
                <button type="button" id="submitBtn">기안</button>
            </div>
        </div>
    )
}

export default Vacation