import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Router } from '@angular/router';
import { Vm } from './Vm';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VmrequestService {

  constructor(private http: HttpClient, private router: Router) { }

    createUser(vmData: any, username: String): Observable<any> {
    console.log('service is called with data ' + vmData);
    return this.http.post('http://localhost:8080/createVmRequest/'+username, vmData, {headers: new HttpHeaders()
    .set('Authorization',localStorage.getItem('ACCESS_TOKEN'))});
 }
}