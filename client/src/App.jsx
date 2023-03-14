import Appbar from "./components/Appbar";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Welcome from "./components/HomePage";
import Welcomemech from "./components/mechanic/Welcomemech";
import Welcomeuser from "./components/user/Welcomeuser";
import Loginmech from "./components/mechanic/Loginmech";
import Registermech from "./components/mechanic/Registermech";
import Logincust from "./components/user/Logincust";
import Welcomeadmin from "./components/admin/Welcomeadmin";
import Loginadmin from "./components/admin/Loginadmin";
import Showcust from "./components/user/Showcust";
import Showmech from "./components/mechanic/Showmech";
import ShowAdmin from "./components/admin/ShowAdmin";
import Registercust from "./components/user/Registercust";
import { useState, useEffect } from "react";
import { useSelector } from "react-redux";

function App() {
	const isAdminLoggedIn = useSelector(state => state.admin.isLoggedIn);
	const isMechanicLoggedIn = useSelector(state => state.mechanic.isLoggedIn);
	const isCustomerLoggedIn = useSelector(state => state.customer.isLoggedIn);
	const state = useSelector(state=> state);
	console.log(state);
  return (
	
    <div>
      <Router>
        <Appbar />
        <br />
        <Routes>
          <Route path="/" exact element={<Welcome />} />
		  {/* {isLogedIn ? <Route path="/welcomeadmin" element={<Welcomeadmin />} /> : <Route path="/loginadmin" element={<Loginadmin />} />} */}
		  {!isAdminLoggedIn && <Route path="/welcomeadmin" element={<Welcomeadmin />} />}
          {!isAdminLoggedIn && <Route path="/loginadmin" element={<Loginadmin />} />}
          {isAdminLoggedIn && <Route path="/admin/:id" element={<ShowAdmin />} />}

          {!isMechanicLoggedIn && <Route path="/welcomemech" element={<Welcomemech />} />}
          {!isMechanicLoggedIn && <Route path="/loginmech" element={<Loginmech />} /> }
          {!isMechanicLoggedIn && <Route path="/addmech" element={<Registermech />} /> }
          {isMechanicLoggedIn && <Route path="/mechanic/:id" element={<Showmech />} /> }

          {!isCustomerLoggedIn && <Route path="/welcomeuser" element={<Welcomeuser />} />}
          {!isCustomerLoggedIn && <Route path="/logincust" element={<Logincust />} />}
          {!isCustomerLoggedIn && <Route path="/addcust" element={<Registercust />} />}
          {isCustomerLoggedIn && <Route path="/customer/:id" element={<Showcust />} />}
        </Routes>
      </Router>
    </div>
	
  );
}

export default App;
