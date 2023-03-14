import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router";
import { useDispatch } from 'react-redux';
import { logout } from '../../features/mechanic/mechanicSlice';
import { Table } from "antd";
import mechanic1 from "../../components/images/mechanic1.jpg";

const Showmech = () => {
  const { id } = useParams();
  const dispatch = useDispatch();
  const [state, setState] = useState({
    id: 0,
    name: "",
    email: "",
    password: "",
    contactno: 0,
    age: 0,
    gender: "",
    createDate: "",
    address: "",
    location: "",
  });

  // const [services, setServices] = useState({
  //   id: 0,
  //   mechanic_id: 0,
  //   name: "",
  //   description: "",
  //   price: 0,
  //   duration: "",
  //   createdAt: "",
  // });

  useEffect(() => {
		const token = localStorage.getItem('token');
		if (token) {
			axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
		}


		axios
			.get(`http://localhost:8080/api/mechanic/getbyid/${id}`)
			.then((data) => setState({ ...data.data }))
			.catch((err) => console.log(err));
	}, [id]);

  const navigate = useNavigate();

  const handleLogout = (event) => {

		event.preventDefault();
		localStorage.removeItem('token');
		delete axios.defaults.headers.common['Authorization'];
		sessionStorage.clear('isLoggedIn');
		sessionStorage.clear('id');
		dispatch(logout());
		navigate("/welcomemech"); // navigate to login page
	};

  const [showDetails, setShowDetails] = useState(false);
  const showHandler = () => {
    setShowDetails(!showDetails);
  };

  const [services, setServices] = useState([]);


  useEffect(() => {
    axios
      .get("http://localhost:8080/api/admin/viewservices")
      .then((response) => setServices([...services, ...response.data]))
      .catch((err) => console.log(err));
  }, []);

  const [showServices, setShowServices] = useState(false);
  const handleShowServices = () => {
    setShowServices(!showServices);
  };

  const columns2 = [
    {
      title: "ID",
      dataIndex: "id",
      key: "id",
    },
    {
      title: "Mechanic ID",
      dataIndex: "mechanic_id",
      key: "mechanic_id",
    },
    {
      title: "Mechanic Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Description",
      dataIndex: "description",
      key: "description",
    },
    {
      title: "Price",
      dataIndex: "price",
      key: "price",
    },
    {
      title: "Operating Hours",
      dataIndex: "duration",
      key: "duration",
    },
    {
      title: "Location",
      dataIndex: "location",
      key: "location",
    },
  ];


  const handleChange = (event) => {
    setState({
      ...state,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    axios.put(`http://localhost:8080/api/mechanic/update/`, state)
      .then(response => {
        console.log(response);
        alert("Data updated successfully!");
      })
      .catch(error => {
        console.error(error);
        alert("Failed to update data!");
      });
  };

  return (
    <div className="container" style={{
			backgroundImage: `url(${mechanic1})`,
			backgroundSize: 'cover',
			height: '100vh',
		  }}>

    <div className="container">
    <button className="btn btn-info" onClick={showHandler}>
      Mechanic Details
    </button>
    {showDetails && (
      <div>
      <h2>Edit Data</h2>
      <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <td>ID:</td>
              <td>
                <input type="text" name="id" value={state.id} disabled />
              </td>
            </tr>
            <tr>
              <td>Name:</td>
              <td>
                <input
                  type="text"
                  name="name"
                  value={state.name}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <td>Email:</td>
              <td>
                <input
                  type="email"
                  name="email"
                  value={state.email}
                  onChange={handleChange}
                />
              </td>
            </tr>
            
            <tr>
              <td>Gender:</td>
              <td>
                <select
                  type="text"
                  name="gender"
                  value={state.gender}
                  onChange={handleChange}
                >
                  <option value="">Select Gender</option>
                  <option value="MALE">Male</option>
                  <option value="FEMALE">Female</option>
                  <option value="other">Other</option>
                  </select>
              </td>
            </tr>
            <tr>
              <td>Age:</td>
              <td>
                <input
                  type="number"
                  name="age"
                  value={state.age}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <td>Contact No:</td>
              <td>
                <input
                  type="text"
                  name="contactno"
                  value={state.contactno}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <td>Address:</td>
              <td>
                <input
                  type="text"
                  name="address"
                  value={state.address}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <td>Location:</td>
              <td>
                <select
                  type="text"
                  name="location"
                  value={state.location}
                  onChange={handleChange}
                > <option value="">Select Location</option>
                  <option value="Akurdi">Akurdi</option>
                  <option value="Aundh">Aundh</option>
                  <option value="Baner">Baner</option>
                  <option value="Balewadi">Balewadi</option>
                  <option value="Shivajinagar">Shivajinagar</option>
                  <option value="Pashan">Pashan</option>
                  <option value="Pimpri">Pimpri</option>
                  <option value="Wakad">Wakad</option>
                </select>
              </td>
            </tr>
            <tr>
              <td colSpan="2">
                <button type="submit">Update Data</button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
    )}

      
    <div>
        <button className="btn btn-info" onClick={handleShowServices}>Show Services</button>
        {showServices && (
          <div>
            <Table dataSource={services} columns={columns2} />
          </div>
        )}
      </div>
	
      <button
        input
        type="submit"
        className="btn btn-info"
        onClick={handleLogout}
      >
        Logout
      </button>
	  
    </div>
    </div>
  );
};

export default Showmech;
