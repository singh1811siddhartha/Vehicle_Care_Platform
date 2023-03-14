import React, { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { Link } from "react-router-dom";
import user from "../../components/images/user.jpg";

const Welcomeuser = () => {
  const [date, setDate] = useState(null);

  useEffect(() => {
    const intervalId = setInterval(() => {
      const nowDate = new Date();
      setDate(
        nowDate.toLocaleString("en-US", {
          weekday: "long",
          year: "numeric",
          month: "short",
          day: "numeric",
          hour: "numeric",
          minute: "numeric",
          second: "numeric",
          hour12: true,
        })
      );
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  return (
    <div
      className="container"
      style={{
        backgroundImage: `url(${user})`,
        backgroundSize: "cover",
        height: "100vh",
      }}
    >
      <Card className="text-center">
        <Card.Body>
          <Card.Title>Welcome To Customer Management</Card.Title>
          <Card.Text>Hello Customers...!!</Card.Text>
          <Link to="/logincust">
            <Button variant="secondary">Login</Button>
          </Link>{" "}
          <Link to="/addcust">
            <Button variant="info">Register</Button>
          </Link>
        </Card.Body>
        <Card.Footer className="text-muted">{date}</Card.Footer>
      </Card>
    </div>
  );
};

export default Welcomeuser;
