import React, { Component } from 'react'
import ApiService from "../service/ApiService";

class AddSalaryComponent extends Component{

    constructor(props){
        super(props);
        this.state ={
            firstName: '',
            lastName: '',
            amount: '',
            message: null
        }
        this.saveSalary = this.saveSalary.bind(this);
    }

    saveSalary = (e) => {
        e.preventDefault();
        let salary = {firstName: this.state.firstName, lastName: this.state.lastName, amount: this.state.amount};
        ApiService.addSalary(salary)
            .then(res => {
                this.setState({message : 'Salary added successfully.'});
                this.props.history.push('/salary');
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    render() {
        return(
            <div>
                <h2 className="text-center">Add Salary</h2>
                <form>
                    <div className="form-group">
                        <label>First Name:</label>
                        <input placeholder="First Name" name="firstName" className="form-control" value={this.state.firstName} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Last Name:</label>
                        <input placeholder="Last name" name="lastName" className="form-control" value={this.state.lastName} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Amount:</label>
                        <input type="number" placeholder="amount" name="amount" className="form-control" value={this.state.amount} onChange={this.onChange}/>
                    </div>
                    <button className="btn btn-success" onClick={this.saveSalary}>Save</button>
                </form>
            </div>
        );
    }
}

export default AddSalaryComponent;