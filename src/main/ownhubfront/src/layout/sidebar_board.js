import React from "react";
import { Link } from "react-router-dom";
import SidebarItem from "./SidebarItem";
// import "./layout.css"
// import profile from "../assets/profile.png";
// import styled from "styled-components";



function Sidebar() {
  const menus = [
    { name: "글쓰기", path: "/board" },
    { name: "공지사항", path: "/content/notice" },
    { name: "부서게시판", path: "/content/teamboard" },
    { name: "자유게시판", path: "/content/freeboard"}
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