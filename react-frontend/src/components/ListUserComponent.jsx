import React, { Component } from 'react';
import UserService from '../services/UserService';

class ListUserComponent extends Component {
    constructor(props){
        super(props)
        this.state={
            users:[]
        }
        this.addUser=this.addUser.bind(this);
        this.editUser=this.editUser.bind(this);
    }
    editUser(id){
        this.props.history.push(`/update-user/${id}`);
    }
    componentDidMount(){
        UserService.getUsers().then((res) =>{
            this.setState({users:res.data});
        }) ;
    }
    addUser(){
        this.props.history.push('/add-user');
        {/*Whenever Add user button is hit, we will be redirected to the above url 
        By Default in routes, react object maintains history and that history is passed as props. 
    So we can manually control the history of the browser*/}
    }
    render() {
        return (
            <div>
                <h2 className="text-center">Users List</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addUser}> Add User</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Mobile Number</th>
                                <th>State</th>
                                <th>Gender</th>
                                <th>Skills</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user=>
                                    <tr key ={user.id}>
                                        <td>{user.name}</td>
                                        <td> {user.email} </td>
                                        <td> {user.mobilenumber} </td>
                                        <td> {user.state} </td>
                                        <td> {user.gender} </td>
                                        <td> {user.skills} </td>
                                        <td>
                                            <button onClick={ () => this.editUser(user.id)} className="btn btn-info">Update</button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListUserComponent;