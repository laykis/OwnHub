import './footer.css'
import React from 'react';

const Footer = () => {
    const thisYear = () => {
        const year = new Date().getFullYear();
        return year
    };
    return (
        <footer className='footer'>
            <p id="main-foot" className="text-center p-2">Copyright &copy; <span>{thisYear()}</span></p>
        </footer>
    )
}

export default Footer