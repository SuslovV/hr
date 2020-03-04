import React, { Component } from 'react'
import ApiService from "../service/ApiService";

class EditSalaryComponent extends Component {

    constructor(props){
        super(props);
        this.state ={
            id: '',
            employee: '',
            firstName: '',
            lastName: '',
            amount: '',
        }
        this.saveSalary = this.saveSalary.bind(this);
        this.loadSalary = this.loadSalary.bind(this);
    }

    componentDidMount() {
        this.loadSalary();
    }

    loadSalary() {
        ApiService.fetchSalaryById(window.localStorage.getItem("salaryId"))
            .then((res) => {
                let salary = res.data.result;
                console.log(salary);
                this.setState({
                    id: salary.id,
                    firstName: salary.employee.firstName,
                    lastName: salary.employee.lastName,
                    amount: salary.amount,
                })
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveSalary = (e) => {
        e.preventDefault();
        let salary = {id: this.state.id, firstName: this.state.firstName, lastName: this.state.lastName, amount: this.state.amount};
        ApiService.editSalary(salary)
            .then(res => {
                this.setState({message : 'Salary added successfully.'});
                this.props.history.push('/salary');
            });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Edit Salary</h2>
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

export default EditSalaryComponent;