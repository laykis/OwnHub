import './layout.css'
import React from 'react';

const Footer = () => {
    const thisYear = () => {
        const year = new Date().getFullYear();
        return year
    };
    return (
        <footer class='footer'>
            <p id="main-foot">Copyright &copy; {thisYear()} 김가네</p>
        </footer>
    )
}

export default Footer