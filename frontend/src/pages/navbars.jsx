import { useEffect } from 'react';
import { Container, Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { setMember } from '../store/member';
import { setModal } from '../store/modal';

const Navbars = (props) => {
    const userdata = useSelector((state) => state.member.data);
    const dispatch = useDispatch();
    console.log(userdata);

    const logout = () => {
        axios.get('/api/logout')
        .then(res => {
            dispatch(setMember(null));
            props.update();
        })
        .catch(error => console.log(error))
    }

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
                    {userdata != null ? <p style={{marginRight:"10px"}}>{userdata.username}님</p> : null}
                    {userdata != null ?
                    <button className="noEffect useButton" onClick={logout}>로그아웃</button> :
                    <button className="noEffect useButton" onClick={() => dispatch(setModal(true))}>로그인</button>
                    }
                </Nav>
            </Container>
        </Navbar>
    );
}

export default Navbars;