// 우리 디비 연결 내용 삽입 
// 예제는 mysql 기준인데 우리 db는 뭐지?

const mysql = require('mysql');
 
const db = mysql.createPool({
    host: 'localhost',
    user: 'test',
    password: '1111',
    database: 'reactboard'
});
 
module.exports = db;