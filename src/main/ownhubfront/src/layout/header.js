import './header.css'
import React from 'react';
// import Tablist from "./tablist";

const MenuItem = ({ active, children, to }) => (
    <div id="menu-item">{children}</div>
  );


const Header = () => {
    return (
        <header className='header'>
            <p id='logo_title'><a href='/'>π» OwnHub</a></p>
            <div id="menu">
                <MenuItem>Git</MenuItem>
                <MenuItem>μ¬μκ΄λ¦¬</MenuItem>
                <MenuItem>κ·Όνκ΄λ¦¬</MenuItem>
                <MenuItem><a href='/content'>κ²μν</a></MenuItem>
            </div>
            <p id="login"><a href='/login'>Login</a></p>
        </header>
    )
}

export default Header