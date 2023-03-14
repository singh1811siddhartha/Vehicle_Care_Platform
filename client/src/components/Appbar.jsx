import React, {useState, useEffect} from 'react';
import { LinkContainer } from 'react-router-bootstrap';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useSelector } from 'react-redux';

const Appbar = () => {
    const id = useSelector(state => state.admin.id);
	let url = !!id ? `/admin/${id}` : "/welcomeadmin";
	const [adminRoute, setAdminRoute] = useState("/welcomeadmin");
	useEffect(() => {
		setAdminRoute(url);
		console.log(url);
	}, [id]);

	const id1 = useSelector(state => state.mechanic.id);
	let url1 = !!id1 ? `/mechanic/${id1}` : "/welcomemech";
	const [mechanicRoute, setMechanicRoute] = useState("/welcomemech");
	useEffect(() => {
		setMechanicRoute(url1);
		console.log(url1);
	}, [id1]);

	const id2 = useSelector(state => state.customer.id);
	let url2 = !!id2 ? `/customer/${id2}` : "/welcomeuser";
	const [customerRoute, setCustomerRoute] = useState("/welcomeuser");
	useEffect(() => {
		setCustomerRoute(url2);
		console.log(url2);
	}, [id2]);

	return (
		<Navbar bg="dark" variant="dark">
			<Container>
				<LinkContainer to="/">
					<Navbar.Brand>Vehicle Care Platform</Navbar.Brand>
				</LinkContainer>
				<Navbar.Toggle aria-controls="basic-navbar-nav" />
				<Navbar.Collapse id="basic-navbar-nav">
					<Nav className="me-auto">
						<LinkContainer to={adminRoute}>
							<Nav.Link>Admin</Nav.Link>
						</LinkContainer>
						<LinkContainer to={mechanicRoute}>
							<Nav.Link>Mechanic</Nav.Link>
						</LinkContainer>
						<LinkContainer to={customerRoute}>
							<Nav.Link>Customer</Nav.Link>
						</LinkContainer>
					</Nav>
				</Navbar.Collapse>
			</Container>
		</Navbar>
	);
};

export default Appbar;
