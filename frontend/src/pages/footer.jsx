import { Container } from "react-bootstrap";


const Footer = () => {
    return (
        <div className="mt-5" style={{height:"200px", backgroundColor:"white"}}>
            <Container style={{padding:"30px"}}>
                <div style={{fontSize:"13px"}}>
                    <p className="mb-0">@ 2023 갈대 Powered by React.js & Spring</p>
                    <p>Origami icons created by Freepik - Flaticon</p>
                </div>
            </Container>
        </div>
    );
}

export default Footer;