'use strict';

const ReactDOM = require('react-dom');
const React = require('react');

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ListSalaryComponent from "./salary/ListSalaryComponent";
import AddSalaryComponent from "./salary/AddSalaryComponent";
import EditSalaryComponent from "./salary/EditSalaryComponent";
import LoginComponent from "./salary/LoginComponent";

class App extends React.Component {

    render() {
        return (
            <div className="container">
                <Router>
                    <div className="col-md-6">
                        <h1 className="text-center" style={style}>React Salary Application</h1>
                        <Switch>
                            <Route path="/" exact component={ListSalaryComponent} />
                            <Route path="/salary" component={ListSalaryComponent} />
                            <Route path="/add-salary" component={AddSalaryComponent} />
                            <Route path="/edit-salary" component={EditSalaryComponent} />
                            <Route path="/login" component={LoginComponent} />
                        </Switch>
                    </div>
                </Router>
            </div>
        )
    }
}
ReactDOM.render(
<App />,
    document.getElementById('react')
)

const style = {
    color: 'red',
    margin: '10px'
}

export default App;