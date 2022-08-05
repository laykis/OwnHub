import React from "react";
import { Link } from "react-router-dom";
import SidebarItem from "./SidebarItem";
import "./layout.css"
// import profile from "../assets/profile.png";
// import styled from "styled-components";



function Sidebar() {
  const menus = [
    { name: "내 Git 보기", path: "/git/mygit" },
    { name: "팀 Git 보기", path: "/git/teamgit" }
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