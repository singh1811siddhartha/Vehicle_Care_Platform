import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router';
import mechanic from "../../components/images/mechanic.jpg";
import { useDispatch } from 'react-redux';
import { login } from '../../features/mechanic/mechanicSlice';

const Loginmech = () => {
	const dispatch = useDispatch();
	const [state, setState] = useState({
		email: '',
		password: '',
	});
	const [error, setError] = useState(false);

	const navigate = useNavigate();
	const loginMechanic = async (loginCreds) => {
		await axios
			.post("http://localhost:8080/api/admin/mechaniclogin/"+state.email+"/"+state.password)
			.then((data) => {
				console.log(data);
				navigate(`/mechanic/${data.data.id}`);
				dispatch(login({isLoggedIn: true, id: data.data.id}));
			})
			.catch((err) => {
				console.log(err);
				resetForm();
				setError(true);
			});
	};
	const resetForm = () => {
		setState({
			email: '',
			password: '',
		});
	};
	const handleChange = (event) => {
		const { name, value } = event.target;
		setState((prevState) => ({ ...prevState, [name]: value }));
	};
	const handleFormSubmit = (event) => {
		event.preventDefault();
		loginMechanic(state);
	};
	const CheckDetails = () => (
		<div className="alert alert-warning " role="alert">
			Check Mechanic Details
		</div>
	);

	return (
		<div className="container" style={{
			backgroundImage: `url(${mechanic})`,
			backgroundSize: 'cover',
			height: '100vh',
		  }}>
			<h3 className="">Login Garage-Owners/Mechanic</h3>
			{error && <CheckDetails />}
			<form onSubmit={handleFormSubmit}>
				<div className="mb-3">
					<label className="form-label">Email</label>
					<input
						type="email"
						required
						name="email"
						id="email"
						className="form-control"
						placeholder="email"
						value={state.email}
						onChange={handleChange}
					/>
				</div>
				<div className="mb-3">
					<label className="form-label">Password</label>
					<input
						type="password"
						required
						name="password"
						id="password"
						className="form-control"
						placeholder="Password"
						value={state.password}
						onChange={handleChange}
					/>
				</div>
				<br />
				<div className="mb-3">
					<input
						type="submit"
						className="btn btn-info"
						value="Login"
					/>
				</div>
			</form>
		</div>
	);
};

export default Loginmech;
