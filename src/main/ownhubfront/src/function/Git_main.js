import React, { useEffect, useState } from "react";
import axios from "axios";
import "../each_page.css";

import CommonTable from "./CommonTable";
import CommonTableColumn from "./CommonColumn";
import CommonTableRow from "./CommonRow";
import Sidebar from "../layout/sidebar_git";

function GetData(){
    // Repo 명단 조회
    const [data, setData] = useState({});
    useEffect(() => {
        axios.get('/teamrepo')
            .then((response)=> {
            setData(response.data);
            })
    }, []);

    const item = (Object.values(data)).map((item) => (
        <CommonTableRow key={item.id}>
            <CommonTableColumn>{item.id}</CommonTableColumn>
            <CommonTableColumn>
                <Link to={`/repo/${item.title}`}>
                    {item.title}
                </Link>
            </CommonTableColumn>
            <CommonTableColumn>{item.wdate}</CommonTableColumn>
            <CommonTableColumn>{item.cuid}</CommonTableColumn>
        </CommonTableRow>
    ));

    return item;
};


function Git_main() {
    const item = GetData();

    // Repository 검색 
    const [search, setRepo] = useState('');
    const onSearch = (e) => {
        console.log(search + " 찾기")
        useEffect(()=>{
            axios.get("/repository/"+search)
                .then(res => setRepo(res.data))
                .catch()
        },[])
    };
    const onChangeRepo = (e) => {
        setRepo(e.target.value);
    };

    // 검색 결과 후 보여주기  
    return (
        <div>
            <Sidebar/>
            <div id='git'>
                <h2 id="page_title">Repository 둘러보기</h2>
                <form id="search" onSubmit={onSearch} >
                    <input 
                        id="search_input" 
                        name="keyword" 
                        value={search} 
                        onChange={onChangeRepo} 
                        placeholder="Search repository"
                    ></input> 
                    <button id="btn_search" type="primary" htmlType="submit">search</button>
                </form>
            </div>
            <div id="result">
                <CommonTable headersName={['번호', '이름', '등록일', '작성자']}>
                    {item}
                </CommonTable>
            </div>
        </div>
    )
}

export default Git_main