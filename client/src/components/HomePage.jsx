import React, { useState, useEffect } from "react";
import { Container, Row, Col, Card } from "react-bootstrap";
import home from "../components/images/home.jpg";

const HomePage = () => {
  const [date, setDate] = useState("");

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

  const [cards, setCards] = useState([
    {
      id: 1,
      title: "VEHICLE CARE PLATFORM",
      text:
        "Vehicle Care Platform is one stop destiation for Customers as well as Mechanics/Garage Owners. It will enable Mechanics/Garage Owners to set up online shops, customers to browse through virtual shops and book the services for regular maintenance or sudden breakdown.",
      cardClicked: false,
    },
    {
      id: 2,
      title: "CUSTOMERS",
      text: "Customers will find it easy to use. Customers will have to sign up and make a registered verified profile before placing an order for any of the services from Services Catalog. It enables user to go through a list of service providers in the locality of proximity, enabling user to choose what they see best for them.",
      cardClicked: false,
    },
    {
      id: 3,
      title: "GARAGE OWNERS / MECHANICS",
      text: "They are the Services and Maintenance providers. From a verified and registered profile they are allowed to provide a list of services which they offer.",
      cardClicked: false,
    },
    {
      id: 4,
      title: "SERVICES & MAINTENANCE",
      text: "This is a list of Services and Maintenance offers provided by Garage owners / Mechanics in order to attract the customers. Customers are free to choose one or many services out of the list present in catalogues.",
      cardClicked: false,
    },
    {
      id: 5,
      title: "APPOINTMENTS & BOOKINGS",
      text: "Based on preferences and requirements the customers choose the services and place the appointments as per their convenience. The Garage Owners or Mechanics will get a notifications based on this appointments, enabling them to provide best possible service to customers.",
      cardClicked: false,
    },
    {
      id: 6,
      title: "REVIEWS & FEEDBACKS",
      text: "Based on the Experience of the services received, the customers can provide ratings or feedback. This will help the Garage Owners/ Mechanic to improve their future performance in more efficient ways.",
      cardClicked: false,
    },
  ]);

  const handleClick = (id) => {
    setCards((prevCards) =>
      prevCards.map((card) => {
        if (card.id === id) {
          return { ...card, cardClicked: !card.cardClicked };
        } else {
          return { ...card, cardClicked: false };
        }
      })
    );
  };

  return (
    <div
      style={{
        backgroundImage: `url(${home})`,
        backgroundSize: "cover",
        height: "100vh",
      }}
    >
      <Container fluid className="h-100">
        <Row className="h-100 align-items-center justify-content-center">
          {cards.map((card) => (
            <Col xs={12} md={6} lg={4} className="mb-4" key={card.id}>
              <Card onClick={() => handleClick(card.id)}>
                <Card.Body>
                  <Card.Title>{card.title}</Card.Title>
                  {card.cardClicked && <Card.Text>{card.text}</Card.Text>}
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>
        <Row>
          <Col className="text-center mt-4">
            <p>{date}</p>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default HomePage;
