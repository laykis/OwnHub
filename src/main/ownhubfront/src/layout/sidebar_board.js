import React from "react";
import { NavLink } from "react-router-dom";
import styled from "styled-components";
import SidebarItem from "./SidebarItem";
// import profile from "../assets/profile.png";

const Side = styled.div`
  display: flex;
  border-right: 1px solid #e0e0e0;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 20%;
`
const Profile = styled.img`
  width: 150px;
  height: 150px;
  border-radius: 100%;
`
const Menu = styled.div`
  margin-top: 30px;
  width: 200px;
  display: flex;
  flex-direction: column;
`

function Sidebar() {
  const menus = [
    { name: "글쓰기", path: "/board" },
    { name: "공지사항", path: "/content/notice" },
    { name: "부서게시판", path: "/content/teamboard" },
    { name: "자유게시판", path: "/content/freeboard"}
  ];

  return (
    <Side>
      <Profile src={profile}></Profile>
      <Menu>
        {menus.map((menu, index) => {
          return (
            <NavLink
              exact
              style={{color: "gray", textDecoration: "none"}}
              to={menu.path}
              key={index}
              activeStyle={{color: "black"}}
            >
              <SidebarItem
                menu={menu}
              />
            </NavLink>
          );
        })}
      </Menu>
    </Side>
  );
}

export default Sidebar;