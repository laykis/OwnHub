import React, { useEffect, useState } from 'react';
import axios from 'axios';
import "../each_page.css";

import CommonTable from "./CommonTable";
import CommonTableColumn from "./CommonColumn";
import CommonTableRow from "./CommonRow";
import Sidebar from '../layout/sidebar_board';

function GetData() {
    const [data, setData] = useState({});
    useEffect(() => {
        axios.get('/board/notice')
            .then((response)=> {
            setData(response.data);
            })
    }, []);

    const item = (Object.values(data)).map((item) => (
        <CommonTableRow key={item.id}>
            <CommonTableColumn>{item.id}</CommonTableColumn>
            <CommonTableColumn>
                <Link to={`/board/${item.id}`}>
                    {item.title}
                </Link>
            </CommonTableColumn>
            <CommonTableColumn>{item.wdate}</CommonTableColumn>
            <CommonTableColumn>{item.cuid}</CommonTableColumn>
        </CommonTableRow>
    ));

    return item;
}

function Notice() {
  const item = GetData();

  return (
    <div>
        <Sidebar/>
        <h2 id="title_page">공지사항</h2>
        <CommonTable headersName={['번호', '제목', '등록일', '작성자']}>
        {item}
        </CommonTable>
    </div>
  );
}
  
export default Notice;