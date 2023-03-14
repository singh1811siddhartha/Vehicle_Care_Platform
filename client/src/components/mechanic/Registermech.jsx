import React, { useState } from "react";
import { useNavigate } from "react-router";
import axios from "axios";
import mechanic from "../../components/images/mechanic.jpg";

const Registermech = () => {
  const [state, setState] = useState({
    name: "",
    email: "",
    age: 0,
    gender: "",
    contactno: 0,
    createDate: "",
    address:"",
    location: "",
    password: "",
  });
  
  const [errors, setErrors] = useState({
    name: "",
    email: "",
    age: "",
    gender: "",
    contactno: "",
    address: "",
    location: "",
    password: "",
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    const now = new Date();
    const formattedDate = `${now.getFullYear()}-${(now.getMonth() + 1)
      .toString()
      .padStart(2, "0")}-${now.getDate().toString().padStart(2, "0")} ${now
      .getHours()
      .toString()
      .padStart(2, "0")}:${now.getMinutes().toString().padStart(2, "0")}:${now
      .getSeconds()
      .toString()
      .padStart(2, "0")}`;
    setState((prevState) => ({
      ...prevState,
      [name]: name === "createDate" ? formattedDate : value,
    }));
  };

  const validate = () => {
    const newErrors = { ...errors };

    if (!state.name) {
      newErrors.name = "Name is required.";
    }

    if (!state.email) {
      newErrors.email = "Email is required.";
    } else if (!/\S+@\S+\.\S+/.test(state.email)) {
      newErrors.email = "Email is invalid.";
    }

    if (!state.age) {
      newErrors.age = "Age is required.";
    } else if (state.age < 18) {
      newErrors.age = "Age must be at least 18.";
    }

    if (!state.gender) {
      newErrors.gender = "Gender is required.";
    }

    if (!state.contactno) {
      newErrors.contactno = "Contact number is required.";
    } else if (state.contactno.toString().length !== 10) {
      newErrors.contactno = "Contact number must be 10 digits.";
    }

    if (!state.address) {
      newErrors.address = "Address is required.";
    }

    if (!state.location) {
      newErrors.location = "Location is required.";
    }

    if (!state.password) {
      newErrors.password = "Password is required.";
    } else if (state.password.length < 8) {
      newErrors.password = "Password must be at least 8 characters.";
    }

    setErrors(newErrors);

    return Object.values(newErrors).every((error) => error === "");
  };

  const saveMechanic = async (mechanic) => {
    await axios
      .post("http://localhost:8080/api/mechanic/add", mechanic)
      .then((data) => console.log(data.data))
      .catch((err) => console.log(err));
  };

  const navigate = useNavigate();

  const handleFormSubmit = (event) => {
    event.preventDefault();

    if (validate()) {
      saveMechanic(state);
      navigate("/Welcomemech");
    }
  };

  return (
    <div className="container" style={{
			backgroundImage: `url(${mechanic})`,
			backgroundSize: 'cover',
			height: '150vh',
		  }}>
      <h3 className="">Register here New Mechanic/Garage-owners</h3>
      <form onSubmit={handleFormSubmit} >
      <div className="mb-3">
          <label className="form-label">Name</label>
          <input
            type="text"
            required
            name="name"
            id="name"
            className="form-control"
            placeholder="name"
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Email</label>
          <input
            type="email"
            required
            name="email"
            id="email"
            className="form-control"
            placeholder="email"
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Age</label>
          <input
            type="number"
            required
            name="age"
            id="age"
            className="form-control"
            placeholder="Age"
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Gender</label>
          <select
            required
            name="gender"
            id="gender"
            className="form-select"
            onChange={handleChange}
          >
            <option value="">Select Gender</option>
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
            <option value="other">Other</option>
          </select>
        </div>
        <div className="mb-3">
          <label className="form-label">Contact Number</label>
          <input
            type="number"
            required
            name="contactno"
            id="contactno"
            className="form-control"
            placeholder="contact number"
            onChange={handleChange}
          />
        </div>
        {/* <div className="mb-3">
          <label className="form-label">CreateDate</label>
          <input
            type="datetime"
            required
            name="createDate"
            id="createDate"
            className="form-control"
            placeholder="System Date Auto"
            onChange={handleChange}
            value={new Date().toISOString()}
            readOnly
          />
        </div> */}
        <div className="mb-3">
          <label className="form-label">Address</label>
          <input
            type="text"
            required
            name="address"
            id="address"
            className="form-control"
            placeholder="address"
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Location</label>
          <select
            required
            name="location"
            id="location"
            className="form-select"
            onChange={handleChange}
          >
            <option value="">Select Location</option>
            <option value="Akurdi">Akurdi</option>
            <option value="Aundh">Aundh</option>
            <option value="Baner">Baner</option>
            <option value="Balewadi">Balewadi</option>
            <option value="Shivajinagar">Shivajinagar</option>
            <option value="Pashan">Pashan</option>
            <option value="Pimpri">Pimpri</option>
            <option value="Wakad">Wakad</option>
          </select>
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
            onChange={handleChange}
          />
        </div>
        <br />
        <div className="mb-3">
          <input type="submit" className="btn btn-info" value="Register" />
        </div>
      </form>
    </div>
  );
};

export default Registermech;
