import axios from "axios";
import React, {useState} from "react";
// import axios from "axios";
import DatePicker from "react-datepicker";
import "../each_page.css";
import Sidebar from "../layout/sidebar_working";

const Vacation = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [endDate,setEndDate] = useState(new Date());
    const [record, setRecord] = useState('');

    const handleRecord = (e) => {
        setRecord(e.target.value)
    }

    const onClickRecord = () =>{
        console.log("time record")
        console.log(startDate, endDate, record)
        axios.post("/workinghour", null, {
            param: {
                "startDate" : startDate,
                "endDate" : endDate,
                "record" : record
            }
        }).then(res => {
            console.log(res)
            if (res.data.result ==="success"){
                window.location.href ="redirect:/workingmonthly"
            }
        })
        .catch()
    }

    

    return (
        <div>
            <Sidebar/>
            <div id="vacation">
                <h2 id="vacation_title">근무 기록</h2>
                <table id="vacation_table" border={0}>
                    <tr>
                        <td><h3>근무기록</h3></td>
                        <td>시작시간</td>
                        <td>
                        <DatePicker
                            closeOnScroll={true} // 스크롤 하면 선택box 닫히게
                            selected={startDate} // 처음에 맨 위에 표시된 input에 나오는게 지금 날짜
                            onChange={(date) => setStartDate(date)} // 내가 선택한 날짜가 맨 위에 표시 됨
                            showTimeSelect // 시간 나오게 하기
                            timeFormat="HH:mm" //시간 포맷 
                            timeIntervals={15} // 15분 단위로 선택 가능한 box가 나옴
                            timeCaption="time"
                            dateFormat="yyyy.MM.dd hh:mm aa"
                            value={startDate}
                            />
                        </td>
                        <td>종료시간</td>
                        <td>
                        <DatePicker
                            closeOnScroll={true} // 스크롤 하면 선택box 닫히게
                            selected={endDate} // 처음에 맨 위에 표시된 input에 나오는게 지금 날짜
                            onChange={(date) => setEndDate(date)} // 내가 선택한 날짜가 맨 위에 표시 됨
                            showTimeSelect // 시간 나오게 하기
                            timeFormat="HH:mm" //시간 포맷 
                            timeIntervals={15} // 15분 단위로 선택 가능한 box가 나옴
                            timeCaption="time"
                            dateFormat="yyyy.MM.dd hh:mm aa"
                            value={endDate}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td><h3>근무내역</h3></td>
                        <td colSpan='4'>
                            <input id = "reason" type="text" name="title" placeholder="근무기록" value={record} onChange={handleRecord}/>
                        </td>
                    </tr>
                </table>
                <button type="button" id="submitBtn" onClick={onClickRecord}>기록</button>
            </div>
        </div>
    )
}

export default Vacation