import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid style={{display: "flex",
                                         justifyContent: "center",
                                         alignItems: "center",
                                         height: "100vh"}}>
                    <Button color="link" style={{fontSize: "3em"}}><Link to="/products">Shopping List</Link></Button>
                </Container>
            </div>
        );
    }
}
export default Home;