import React, { useState } from 'react';
import Calendar from 'react-calendar';
import "../each_page.css";

import Sidebar from '../layout/sidebar_working';

function Plan(){
  return (
    <div id='plan'>
      <h2 id='vacation_title'>일정</h2>
    </div>
  )
}

function Workday() {
  const [value, onChange] = useState(new Date());

  return (
    <div>
        <Sidebar/>
        <Calendar onChange={onChange} value={value} />
        <Plan/>
    </div>
  );
}
export default Workday