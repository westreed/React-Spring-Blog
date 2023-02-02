import axios from 'axios';
import { RSAKey } from 'jsencrypt/lib/lib/jsbn/rsa';
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
    const [pwType, setPwType] = useState('password');
    const [publicKey, setPublicKey] = useState({'modulus':null, 'exponent':null});

    function getRsaKey(){
        axios.get('api/key')
        .then(res => {
            setPublicKey({
                'modulus':res.data['modulus'],
                'exponent':res.data['exponent']
            });
        })
        .catch(error => console.log("key 받아오기 실패", error))
    }

    useEffect(() => {
        getRsaKey();
    }, [])

    const loginUser = () => {
        if (email === '' || password === ''){
            alert("이메일과 비밀번호를 입력해주세요.");
            return false;
        }

        if (publicKey['modulus'] == null) {
            getRsaKey();
            alert("서버에 오류가 발생했습니다.");
            return false;
        }

        const rsa = new RSAKey();
        rsa.setPublic(publicKey['modulus'], publicKey['exponent']);

        axios.post("/api/login", {
            "email" : rsa.encrypt(email),
            "password" : rsa.encrypt(password)
        })
        .then(res => {
            console.log("로그인 성공! " + res.data);
            props.onHide();
            sessionStorage.setItem("userInfo", JSON.stringify({"email":email, "name":res.data.username, "role":res.data.role}));
        })
        .catch(error => {
            console.log(error.response);
            switch (error.response.status) {
                case 404:
                    alert("없는 이메일이거나 잘못된 비밀번호입니다.");
                    break;
                
                case 403:
                    getRsaKey();
            
                default:
                    alert("서버에 문제가 발생했습니다.");
                    break;
            }
        })
    }

    const togglePW = () => {
        setShowPW(!showPW);
        if(showPW){setPwType('password');}
        else{setPwType('text');}
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
                        <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between"}}>
                            <Form.Control
                                className="shadow-none"
                                type={pwType}
                                placeholder="********"
                                onChange={(e) => setPassword(e.target.value)}
                            />
                            <div style={{margin:"auto", paddingRight:"12px"}} onClick={togglePW}><img src={showPW ? viewImg : hideImg} width="20px" height="20px" alt="" /></div>
                        </div>
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