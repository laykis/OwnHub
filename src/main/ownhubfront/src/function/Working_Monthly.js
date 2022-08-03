import React, { useState } from 'react';
import Calendar from 'react-calendar';
import "../each_page.css";

import Sidebar from '../layout/sidebar_working';

function Workday() {
  const [value, onChange] = useState(new Date());

  return (
    <div>
        <Sidebar/>
        <Calendar onChange={onChange} value={value} />
    </div>
  );
}
export default Workday