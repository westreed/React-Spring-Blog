import { Container, Nav, Navbar } from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { setModal } from '../store/modal';
import { useDispatch, useSelector } from 'react-redux';
import { setMember } from '../store/member';

const Navbars = () => {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const member = useSelector((state) => state.member.data)

    const logout = () => {
        axios.get('/api/logout')
        .then(res => {
            dispatch(setMember(null));
            navigate('/');
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
                    <Link className='brand' to="/">:AiM</Link>
                    <Link className='useButton' to='/'>Home</Link>
                    <Link className='useButton' to='/category'>Categories</Link>
                    <Link className='useButton' to='/tags'>Tags</Link>
                </Nav>
                <Nav style={{height:"50px", lineHeight:"50px", justifyContent:"flex-end"}}>
                    {member != null ? <p style={{marginRight:"10px"}}>{member.username}님</p> : null}
                    {member != null ?
                    <button className="noEffect useButton" onClick={logout}>로그아웃</button> :
                    <button className="noEffect useButton" onClick={() => dispatch(setModal(true))}>로그인</button>
                    }
                </Nav>
            </Container>
        </Navbar>
    );
}

export default Navbars;