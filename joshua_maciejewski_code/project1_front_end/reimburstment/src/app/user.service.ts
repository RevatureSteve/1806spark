import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }


  updateUser(u_id, email, password, fname, lname) {
    const user = {
      u_id: u_id,
      email: email,
      password: password,
      fname: fname,
      lname: lname
    };
    //console.log(JSON.parse(user) + "   testing")
    localStorage.setItem('user', JSON.stringify(user));
    console.log(user + "   after changes")
    return this.httpClient.put<User>('http://localhost:8080/project1/GetAllEmployeesServlet', user);

  }


//get all employees

getallemployees() {
  return this.httpClient.get<User[]>(`http://localhost:8080/project1/GetAllEmployeesServlet`);
}




}
