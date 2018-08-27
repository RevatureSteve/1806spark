import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reim } from 'c:/Users/Joshua/my_git_repos/1806spark/joshua_maciejewski_code/project1_front_end/reimburstment/src/app/models/reim';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private httpClient: HttpClient, private router: Router) { }


  resolvedreimbursements() {
    return this.httpClient.get<Reim[]>(`http://localhost:8080/project1/ResolvedRequestsServlet`);
  }
  
  pendingreimbursements() {
    return this.httpClient.get<Reim[]>(`http://localhost:8080/project1/managerViewPendingServlet`);
  }

  
  employeeresolved(id) {

    console.log("is id working  "  +  id)
    console.log("services")
    return this.httpClient.get<Reim[]>(`http://localhost:8080/project1/EmployeeResolvedServlet/id?u_id=${id}`);
  }
  


  employeeviewpending(id) {

  console.log("is id working  "  +  id)
  console.log("services")
  return this.httpClient.get<Reim[]>(`http://localhost:8080/project1/EmployeeViewPendingServlet/id?u_id=${id}`);
}

getReimById(id) {

  console.log("is id working  "  +  id)
  console.log("services")
  return this.httpClient.get<Reim[]>('http://localhost:8080/project1/ReimByIdServlet/id' + '?u_id=' + id);
}


  createReimbursement(empUId, amt, description, rqTypeId, img) {
    const reim = {
      empUId: empUId,
      amt: amt,
      description: description,
      img: img,
      rqTypeId: rqTypeId
    };

    console.log(reim);

    return this.httpClient.post<Reim>('http://localhost:8080/project1/createReimbursementServlet', reim);
}

changeReimStatus(rId, mgrUId, rqStatusId) {
  const reim = {
    rId: rId,
    mgrUId: mgrUId,
    rqStatusId: rqStatusId
  };
  console.log(reim);

  return this.httpClient.put<Reim>('http://localhost:8080/project1/ChangeReimStatusServlet', reim);
}

}