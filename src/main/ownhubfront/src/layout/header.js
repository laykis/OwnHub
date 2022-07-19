import './header.css'
import {Route, Link} from 'react-router-dom';
import React from 'react';


const Header = () => {
    return (
        <header className='header'>
            <p id='logo_title'><a href='/'>💻 OwnHub</a></p>
            {/*<Link to="/">💻 OwnHub</Link>*/}
            <p id="login"><a href='/login'>Login</a></p>
        </header>
    )
}

export default Header