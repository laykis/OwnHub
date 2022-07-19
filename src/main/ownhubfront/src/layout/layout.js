import React from "react";
import "./layout.css"

const Layout = () => {
    return (
        <div className='intro'>
            <div class="column-left">
                <p id = "second_title">
                    그룹 웨어와 형상관리를 함께 사용합니다.
                </p>
                <blockquote>
                    <h2 id = 'title'>
                        그룹웨어에서 <br/>
                        Git을 관리해보세요
                    </h2>
                </blockquote>
                <strong>
                    기존에 있던 그룹웨어에 개발자를 위한 기능을 추가하였습니다.
                </strong>
                <p>
                    HR에 있는 사람 뿐만 아니라 SQA, OA, SM, SI 모두가 편하게 사용할 수 있는 개발 환경이 포함된 그룹웨어로 개발 이력 관리가 용이하며, 개발자 간의 교류가 더 쉽게 하였습니다.
                </p>
                <strong>
                그렇다고 해서 그룹웨어의 기능을 놓치지 않았습니다.
                </strong>
                <p>
                평소 사용하던 그룹웨어의 기능을 그대로 간직하고 있습니다.<br/>
                그래서 저희는 개발이 주로 이루어지고 있는 회사를 위한 새로운 형태의 그룹웨어를 제안합니다.
                </p>
            </div>
            <div class="column-right">   
                <img id="img_1_intro" src="src\main\ownhubfront\img\img_1_intro.png"></img>
            </div>
        </div>
    )
}

export default Layout