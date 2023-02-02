import { useEffect, useState } from 'react';
import { Container, Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Navbars = (props) => {
    const [username, setUsername] = useState(null);
    const [useremail, setUseremail] = useState(null);

    useEffect(() => {
        const res = JSON.parse(sessionStorage.getItem("userInfo"));
        if (res){
            setUsername(res.name);
            setUseremail(res.email);
        }
    })

    return (
        <Navbar className='shadow-sm mb-4 bg-body rounded' style={{padding:0}}>
            <Container
                style={{
                    paddingLeft:"30px",paddingRight:"30px"
                }}
            >   
                <Nav style={{height:"50px", lineHeight:"50px", justifyContent:"flex-start"}}>
                    <a className='brand' href="/">:AiM</a>
                    <Link className='useButton' to='/'>Home</Link>
                    <Link className='useButton' to='/categories'>Categories</Link>
                </Nav>
                <Nav style={{height:"50px", lineHeight:"50px", justifyContent:"flex-end"}}>
                    {useremail != null ? <p style={{marginRight:"10px"}}>{username}님</p> : null}
                    {useremail != null ?
                    <button className="noEffect useButton">로그아웃</button> :
                    <button className="noEffect useButton" onClick={props.onShow}>로그인</button>
                    }
                </Nav>
            </Container>
        </Navbar>
    );
}

export default Navbars;