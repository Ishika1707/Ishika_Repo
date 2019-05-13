import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  display = false;
  constructor(private http: HttpClient) {}

  createUser(userData: any) : Observable<any> {
    console.log('service is called with data ' + userData);
    return this.http.post('http://localhost:8080/createUser', userData,
      {headers: new HttpHeaders().set('Content-Type', 'application/json' )
    .append('Access-Control-Allow-Headers', '*').append('Access-Control-Allow-Origin', '/**')
    .append('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS')}
    );
  }

}
