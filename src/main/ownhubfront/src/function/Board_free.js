import React, { useEffect, useState } from 'react';
import axios from 'axios';
import "../each_page.css";

import CommonTable from "./Board_common";
import CommonTableColumn from "./Board_commoncolumn";
import CommonTableRow from "./Board_commonrow";
import Sidebar from '../layout/sidebar_board';

function GetData() {
  const [data, setData] = useState({});
  useEffect(() => {
    axios.get('/board/free').then((response)=> {
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

function Freeboard() {
  const item = GetData();

  return (
    <div>
        <Sidebar/>
        <h2 id="title_page">자유게시판</h2>
        <CommonTable headersName={['번호', '제목', '등록일', '작성자']}>
        {item}
        </CommonTable>
    </div>
  );
}
  
export default Freeboard;