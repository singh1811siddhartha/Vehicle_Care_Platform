import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router";
import { useDispatch } from "react-redux";
import { logout } from "../../features/admin/adminSlice";
import { Table } from "antd";
import admin1 from "../../components/images/admin1.jpg";

const ShowAdmin = () => {
  const dispatch = useDispatch();
  const { id } = useParams();
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

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (token) {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
    }

    axios
      .get(`http://localhost:8080/api/admin/getbyid/${id}`)
      .then((data) => setState({ ...data.data }))
      .catch((err) => console.log(err));
  }, [id]);

  const navigate = useNavigate();

  const handleLogout = (event) => {
    event.preventDefault();
    localStorage.removeItem("token");
    delete axios.defaults.headers.common["Authorization"];
    sessionStorage.clear("isLoggedIn");
    sessionStorage.clear("id");
    dispatch(logout());
    navigate("/welcomeadmin"); // navigate to login page
  };

  const [showDetails, setShowDetails] = useState(false);
  const showHandler = () => {
    setShowDetails(!showDetails);
  };

  const [users, setUsers] = useState([]);
  const [mech, setMech] = useState([]);
  const [veh, setVeh] = useState([]);
  const [services, setServices] = useState([]);


  useEffect(() => {
    axios
      .get("http://localhost:8080/api/admin/viewuser")
      .then((response) => setUsers([...users, ...response.data]))
      .catch((err) => console.log(err));

	axios
      .get("http://localhost:8080/api/admin/viewmechanic")
      .then((response) => setMech([...mech, ...response.data]))
      .catch((err) => console.log(err));

	axios
      .get("http://localhost:8080/api/admin/viewvehicles")
      .then((response) => setVeh([...veh, ...response.data]))
      .catch((err) => console.log(err));

	axios
      .get("http://localhost:8080/api/admin/viewservices")
      .then((response) => setServices([...services, ...response.data]))
      .catch((err) => console.log(err));
  }, []);

  const columns = [
    {
      title: "ID",
      dataIndex: "id",
      key: "id",
    },
    {
      title: "Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Age",
      dataIndex: "age",
      key: "age",
    },
    {
      title: "Email",
      dataIndex: "email",
      key: "email",
    },
    {
      title: "Contact No",
      dataIndex: "contactno",
      key: "contactno",
    },
    {
      title: "Gender",
      dataIndex: "gender",
      key: "gender",
    },
    {
      title: "Address",
      dataIndex: "address",
      key: "address",
    },
    {
      title: "Location",
      dataIndex: "location",
      key: "location",
    },
  ];

  const [showUsers, setShowUsers] = useState(false);
  const handleShowUsers = () => {
    setShowUsers(!showUsers);
  };

  const [showMech, setShowMech] = useState(false);
  const handleShowMech = () => {
    setShowMech(!showMech);
  };

  const [showVeh, setShowVeh] = useState(false);
  const handleShowVeh = () => {
    setShowVeh(!showVeh);
  };

  const [showServices, setShowServices] = useState(false);
  const handleShowServices = () => {
    setShowServices(!showServices);
  };

  const columns1 = [
    {
      title: "ID",
      dataIndex: "id",
      key: "id",
    },
    {
      title: "Customer ID",
      dataIndex: "user_id",
      key: "user_id",
    },
    {
      title: "Make",
      dataIndex: "make",
      key: "make",
    },
    {
      title: "Model",
      dataIndex: "model",
      key: "model",
    },
    {
      title: "Year of Purchase",
      dataIndex: "year",
      key: "year",
    },
    {
      title: "Color",
      dataIndex: "color",
      key: "color",
    },
    {
      title: "Address",
      dataIndex: "licensePlate",
      key: "licensePlate",
    },
  ];

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
    axios.put(`http://localhost:8080/api/admin/updateadmin/`, state)
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
		backgroundImage: `url(${admin1})`,
		backgroundSize: 'cover',
		height: '100vh',
	  }}>

    <div className="container    ">
      <button className="btn btn-info" onClick={showHandler}>
        Administrator Details
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
                  type="text"
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
        <button className="btn btn-info" onClick={handleShowUsers}>Show Customers</button>
        {showUsers && (
          <div>
            <Table dataSource={users} columns={columns} />
          </div>
        )}
      </div>

	  <div>
        <button className="btn btn-info" onClick={handleShowMech}>Show Mechanic</button>
        {showMech && (
          <div>
            <Table dataSource={mech} columns={columns} />
          </div>
        )}
      </div>


	  <div>
        <button className="btn btn-info" onClick={handleShowVeh}>Show Vehicles</button>
        {showVeh && (
          <div>
            <Table dataSource={veh} columns={columns1} />
          </div>
        )}
      </div>

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

export default ShowAdmin;
