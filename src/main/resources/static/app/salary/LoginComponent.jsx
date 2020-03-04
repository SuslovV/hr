import React, { Component } from 'react'

class LoginComponent extends Component{

    constructor(props){
        super(props);
        this.state ={
            username: '',
            password: '',
            message: null
        }
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    render() {
        return(
            <div>
                <h2 className="text-center">Login Salary</h2>
                <form name='f' action='j_spring_security_check' method='POST'>
                    <table>
                        <tr>
                            <td>User:</td>
                            <td><input type='text' name='username' /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type='password' name='password' /></td>
                        </tr>
                        {/*<tr>*/}
                        {/*    <td>Remember Me?</td>*/}
                        {/*    <td><input type="checkbox" name="remember-me" /></td>*/}
                        {/*</tr>*/}
                        <tr>
                            <td><input name="submit" type="submit" value="submit" /></td>
                        </tr>
                    </table>
                </form>
                <label> Username/pass:</label>
                <ul>
                    {/*<li>dbuser1/123</li>*/}
                    <li>USER/USER</li>
                </ul>
            </div>
        );
    }
}

export default LoginComponent;
