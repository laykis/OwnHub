import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Calendar from 'react-calendar';
import "../each_page.css";

import Sidebar from '../layout/sidebar_working';

function Plan(){
  const [plan, setPlan] = useState([]);
  useEffect(()=>{
    axios.get('/monthplan').then((response)=>{
      setPlan(response.data);
    })
  },[])

  const item = (
    <div>
      <ul>
        <li>일정 </li>
        <li>{plan.sdate} ~ {plan.edate} : {plan.stitle} </li>
      </ul>
    </div>
  )
  return item
}

function Workday() {
  const [value, onChange] = useState(new Date());
  const item = Plan();

  return (
    <div>
      <Sidebar/>
      <Calendar onChange={onChange} value={value} />
      <div id='plan'>
        <h2 id='vacation_title'>일정</h2>
        {item}
      </div>
    </div>
  );
}
export default Workday