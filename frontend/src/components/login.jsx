import axios from 'axios';
import { useEffect, useState } from 'react';
import { Form } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { Link } from 'react-router-dom';

import hideImg from '../images/hide.png';
import viewImg from '../images/view.png';


const Login = (props) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [showPW, setShowPW] = useState(false);

    useEffect(() => {
        console.log("입력값" + email + password);
    }, [email, password]);

    const loginUser = () => {
        const data = {
            "email" : email,
            "password" : password
        }
        axios.post("/api/login", data)
        .then(res => console.log("로그인 성공! " + res.data))
        .catch(error => console.log("로그인 실패! " + error))
    }

    const togglePW = () => {
        setShowPW(!showPW);
    }

    return (
        <Modal
            {...props}
            dialogClassName="modal-s2" // css 용 클래스 이름
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Body>
                <button className="noEffect close" style={{float:"right"}} onClick={props.onHide}>×</button>
                <h5>로그인</h5>
                <Form>
                    <Form.Group className="mt-4 mb-3 outline" controlId="Form1">
                        <Form.Label>이메일</Form.Label>
                        <Form.Control
                            className="shadow-none"
                            type="email"
                            placeholder="Email"
                            onChange={(e) => setEmail(e.target.value)}
                            autoFocus
                        />
                    </Form.Group>
                    <Form.Group className="mb-3 outline" controlId="Form2"
                    >
                        <Form.Label>비밀번호</Form.Label>
                        <Form.Control
                            className="shadow-none"
                            type="password"
                            placeholder="********"
                            onChange={(e) => setPassword(e.target.value)}
                        />
                        <button className="noEffect" onClick={togglePW}><img src={showPW ? viewImg : hideImg} width="24px" height="24px" /></button>
                    </Form.Group>
                    <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between"}}>
                        <Form.Check type='checkbox' label='로그인 유지'/>
                        <div>
                            <Link to="/join" onClick={props.onHide} style={{color:"212121", marginRight:"10px"}}>회원가입</Link>
                            <Link to="/find" onClick={props.onHide}>ID/PW 찾기</Link>
                        </div>
                    </div>
                    <Button style={{width:"100%", marginTop:"20px", backgroundColor:"#7286D3"}} onClick={loginUser}>로그인</Button>
                </Form>
            </Modal.Body>
        </Modal>
    );
}

export default Login;