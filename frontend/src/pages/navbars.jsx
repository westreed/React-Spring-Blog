import { Container, Nav, Navbar } from 'react-bootstrap';

const Navbars = () => {
    return (
        <Navbar className='shadow-sm p-2 mb-4 bg-body rounded'>
            <Container style={{paddingLeft:"30px", paddingRight:"30px"}}>
                <Navbar.Brand href='/'>:AiM</Navbar.Brand>
                <Nav className="me-auto">
                    <Nav.Link href='/'>Home</Nav.Link>
                    <Nav.Link href='/categories'>Categories</Nav.Link>
                </Nav>
                <Navbar.Collapse className="justify-content-end">
                    <Nav.Link>로그인</Nav.Link>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default Navbars;