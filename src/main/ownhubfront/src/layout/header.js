import './layout.css'
import React from 'react';

const MenuItem = ({ active, children, to }) => (
    <div id="menu-item">{children}</div>
  );


const Header = () => {
    return (
        <header className='header'>
            <p id='logo_title'><a href='/'>💻 OwnHub</a></p>
            <div id="menu">
                <MenuItem><a href='/git/mygit'>Git</a></MenuItem>
                <MenuItem><a href='/members'>사원관리</a></MenuItem>
                <MenuItem><a href='/working/monthly'>근태관리</a></MenuItem>
                <MenuItem><a href='/content/notice'>게시판</a></MenuItem>
            </div>
            <p id="login"><a href='/login'>Login </a></p>
        </header>
    )
}

export default Header