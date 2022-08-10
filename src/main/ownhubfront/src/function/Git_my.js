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
        axios.get('/myrepo')
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
}


const Git_my = () => {
    const item = GetData();

    // Git 생성 
    const [name, setName] = useState('');

    const onSubmit = (e) => {
        e.preventDefault();
        console.log("Create Repository "+ name)
  
        axios.post("/main/createrepo", null, {
          param: {"name" : name}
        })
          .then(res => {
              console.log(res)
              if(res.data.result === "success"){
                  console.log("Create success")
                  alert(name+" Repository가 생성되었습니다. ")
                  window.location.href = ("redirect:/mygit")
              }
          })
          .catch()
    };
    const onChangeName = (e) => {
        setName(e.target.value);
    };

    // Git clone
    const [clone, setClone] = useState('');

    const onClone = (e) => {
        e.preventDefault();
        console.log("Clone Repository "+ clone)
        axios.post("/main/clonerepo", null, {
          param: {"clone" : clone}
        })
          .then(res => {
              console.log(res)
              if(res.data.result === "success"){
                  console.log("Clone success")
                  window.location.href = ("redirect:/mygit/"+clone)
              }
          })
          .catch()
    };
    const onCloneName = (e) => {
        setClone(e.target.value);
    };



    return (
        <div>
            <Sidebar/>
            <div id="git">
                <h2 id='page_title'>나의 Git</h2>
                <form id='repo-create'  onSubmit={onSubmit}>
                    <div>
                        <input id="git_input" name="repo-title" value={name} onChange={onChangeName} placeholder='Repository 이름'></input>
                        <button id="gitBtn" type="primary" htmlType="submit">Repository 생성</button>
                    </div>
                </form>
                <form id='repo-clone'  onSubmit={onClone}>
                    <div>
                        <input id="git_input" name="clone-title" value={clone} onChange={onCloneName} placeholder='Repository 이름'></input>
                        <button id="gitBtn" type="primary" htmlType="submit">클론 주소 복사하기</button>
                    </div>
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

export default Git_my