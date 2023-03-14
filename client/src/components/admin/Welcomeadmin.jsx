import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { Link } from 'react-router-dom';
import admin from "../../components/images/admin.jpg";

const Welcomeadmin = () => {
  const [date, setDate] = useState('');

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
    <div className="container"
      style={{
        backgroundImage: `url(${admin})`,
        backgroundSize: 'cover',
        height: '100vh',
      }}>
      <Card className="text-center">
        <Card.Body>
          <Card.Title>Welcome Administrator</Card.Title>
          <Card.Text></Card.Text>
          <Link to="/loginadmin">
            <Button variant="secondary">Login</Button>
          </Link>
        </Card.Body>
        <Card.Footer className="text-muted">{date}</Card.Footer>
      </Card>
    </div>
  );
};

export default Welcomeadmin;
