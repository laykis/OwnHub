import React, { useEffect, useState } from 'react';
import axios from 'axios';
import "../each_page.css";
import Sidebar from '../layout/sidebar_board';

import CommonTable from "./CommonTable";
import CommonTableColumn from "./CommonColumn";
import CommonTableRow from "./CommonRow";

function GetData() {
  const [data, setData] = useState({});
  useEffect(() => {
    axios.get('/board/teamboard').then((response)=> {
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

function Teamboard() {
  const item = GetData();

  return (
    <div>
        <Sidebar/>
        <h2 id="title_page">부서게시판</h2>
        <CommonTable headersName={['번호', '제목', '등록일', '작성자']}>
        {item}
        </CommonTable>
    </div>
  );
}
  
export default Teamboard;