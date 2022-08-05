import React from "react";
import { Link } from "react-router-dom";
import SidebarItem from "./SidebarItem";
import "./layout.css"
// import profile from "../assets/profile.png";
// import styled from "styled-components";



function Sidebar() {
  const menus = [
    { name: "마이 페이지", path: "/mypage" },
    { name: "사원관리", path: "/members" },
    { name: "관리자 페이지", path: "/management" }
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