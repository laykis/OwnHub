import React from "react";
import { Link } from "react-router-dom";
import SidebarItem from "./SidebarItem";
// import "./layout.css"
// import profile from "../assets/profile.png";
// import styled from "styled-components";



function Sidebar() {
  const menus = [
    { name: "월간 일정", path: "/working/monthly" },
    { name: "근무시간 기록", path: "/working/record" },
    { name: "휴가신청", path: "/working/vacation" }
  ];

  return (
    <div id='side'>
      {menus.map((menu, index) => {
        return (
          <Link to={menu.path} key={index} style={{color: "gray", textDecoration: "none"}} >
            <SidebarItem menu={menu} />
          </Link>
        );
      })}
    </div>
  );
}

export default Sidebar;