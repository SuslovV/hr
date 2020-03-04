import React, {Component} from 'react'
import ApiService from "../service/ApiService";

class ListSalaryComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            salary: [],
            message: null
        }
        this.deleteSalary = this.deleteSalary.bind(this);
        this.editSalary = this.editSalary.bind(this);
        this.addSalary = this.addSalary.bind(this);
        this.reloadSalaryList = this.reloadSalaryList.bind(this);
    }

    componentDidMount() {
        this.reloadSalaryList();
    }

    reloadSalaryList() {
        ApiService.fetchSalary()
            .then((res) => {
                this.setState({salary: res.data.result})
            });
    }

    deleteSalary(salaryId) {
        ApiService.deleteSalary(salaryId)
            .then(res => {
                this.setState({message: 'Salary deleted successfully.'});
                this.setState({salary: this.state.salary.filter(salary => salary.id !== salaryId)});
            })
    }

    editSalary(id) {
        window.localStorage.setItem("salaryId", id);
        this.props.history.push('/edit-salary');
    }

    addSalary() {
        window.localStorage.removeItem("salaryId");
        ApiService.fetchSalaryAdd()
            .then((res) => {
                if (res.data == 1) {
                    this.props.history.push('/add-salary');
                } else {
                    console.log(res.request.responseURL);
                    this.setState({ currentUrl: '/login' });
                    this.props.history.push('/login');
                }
            });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Salary Details</h2>
                <button className="btn btn-danger" style={{width: '100px'}} onClick={() => this.addSalary()}> Add
                    Salary
                </button>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th className="hidden">Id</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.salary.map(
                            salary =>
                                <tr key={salary.id}>
                                    <td>{salary.employee.firstName}</td>
                                    <td>{salary.employee.lastName}</td>
                                    <td>{salary.amount}</td>
                                    <td>
                                        <button className="btn btn-success"
                                                onClick={() => this.deleteSalary(salary.id)}> Delete
                                        </button>
                                        <button className="btn btn-success" onClick={() => this.editSalary(salary.id)}
                                                style={{marginLeft: '20px'}}> Edit
                                        </button>
                                    </td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>

            </div>
        );
    }
}

export default ListSalaryComponent;