import logo from './logo.svg';
import './App.css';
import React, { Component }  from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListUserComponent from './components/ListUserComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateUserComponent from './components/CreateUserComponent';
import UpdateUserComponent from './components/UpdateUserComponent';
function App() {
  return (
    <div>
      <Router>
      <HeaderComponent/> 
      <div className="container">
        <Switch>
          <Route path="/" exact component={ListUserComponent}></Route>
          <Route path="/users" component={ListUserComponent}></Route>
          <Route path="/add-user" component={CreateUserComponent}></Route>
          <Route path="/update-user/:id" component={UpdateUserComponent}></Route>
        </Switch>
      </div>
      <FooterComponent/>
      </Router>
    </div>

  );
}

export default App;
