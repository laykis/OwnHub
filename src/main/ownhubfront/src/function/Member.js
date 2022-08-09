import React, {useState, useEffect} from "react";
import axios from "axios";
import "../each_page.css";
import Sidebar from "../layout/sidebar_member";

import CommonTable from "./CommonTable8";
import CommonTableColumn from "./CommonColumn";
import CommonTableRow from "./CommonRow";

const Search = () => {
    const [user, setUser] = useState([])
    const userInfo = (e) => {
        setUser(e.target.value)
    }

    useEffect(()=>{
        axios.get("/member_list")
            .then(res => userInfo(res))
            .catch()
    }, []
    )

    return (
        <div>
            <form id="search">
                <input 
                    id="search_input" 
                    name="keyword" 
                    value={user}
                    placeholder="사원 검색"
                ></input> 
                <button id="btn_search">search</button>
            </form>
        </div>
    )
};

function GetData() {
    const [data, setData] = useState({});
    useEffect(() => {
        axios.get('/memberlist').then((response)=> {
        setData(response.data);
        })
    }, []);

    const item = (Object.values(data)).map((item) => (
        <CommonTableRow key={item.id}>
            <CommonTableColumn>{item.id}</CommonTableColumn>
            <CommonTableColumn>{item.username}</CommonTableColumn>
            <CommonTableColumn>{item.team}</CommonTableColumn>
            <CommonTableColumn>{item.auth}</CommonTableColumn>
            <CommonTableColumn>{item.email}</CommonTableColumn>
            <CommonTableColumn>
                <Link to={`/member/${item.id}`}>Repo</Link>
            </CommonTableColumn>
            <CommonTableColumn>
                <Link to={`/member/${item.id}`}>쪽지 보내기</Link>
            </CommonTableColumn>
        </CommonTableRow>
    ));

  return item;
};

function Member() {
    const item = GetData();

    return (
        <div>
            <Sidebar/>
            <Search/>
            <h2 id="title_page">사원관리</h2>
            <CommonTable headersName={['사원번호', '이름', '소속팀', '직급', '이메일', 'Repository 보기', '쪽지 보내기']}>
            {item}
            </CommonTable>
        </div>
    );
}
  
export default Member;