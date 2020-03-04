import axios from 'axios';

const Salary_API_BASE_URL = 'http://localhost:8484/salary';
const Salary_API_BASE_URL2 = 'http://localhost:8484';

class ApiService {

    fetchSalary() {
        return axios.get(Salary_API_BASE_URL);
    }

    fetchSalaryAdd() {
        return axios.get(Salary_API_BASE_URL + '/add-salary');
    }

    fetchSalaryById(salaryId) {
        return axios.get(Salary_API_BASE_URL + '/' + salaryId);
    }

    deleteSalary(salaryId) {
        return axios.delete(Salary_API_BASE_URL + '/' + salaryId);
    }

    addSalary(salary) {
        return axios.post(""+Salary_API_BASE_URL, salary);
    }

    editSalary(salary) {
        return axios.put(Salary_API_BASE_URL + '/' + salary.id, salary);
    }

    login(loginPass) {
        return axios.post(""+Salary_API_BASE_URL2 + '/j_spring_security_check', loginPass);
    }
}

export default new ApiService();