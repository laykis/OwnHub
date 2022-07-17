import React from "react";
import Footer from "./footer";
import Header from "./header";
import "./layout.css"

const Layout = (props: {
    children : React.ReactNode
}) => {
    return (
        <div className='layout'>
            <Header />
            <main>
                {props.children}
                <h2>전체적인 레이아웃</h2>
            </main>
            <Footer />
        </div>
    )
}

export default Layout