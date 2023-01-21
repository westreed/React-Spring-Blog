import { Container, Nav, Navbar } from 'react-bootstrap';

const Navbars = () => {
    return (
        <Navbar>
            <Container>
                <Navbar.Brand href='/'>React-Bootstrap</Navbar.Brand>
                <Nav className="me-auto">
                    <Nav.Link href='/'>Home</Nav.Link>
                    <Nav.Link href='/categories'>Categories</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    );
}

export default Navbars;