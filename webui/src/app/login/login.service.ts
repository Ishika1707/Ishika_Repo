import { Injectable } from '@angular/core';
// import { Login } from './login';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(loginInfo: any): Observable<any> {
    return this.http.post('http://localhost:8080/login', loginInfo, {headers: new HttpHeaders().set('Content-Type', 'application/json' )
    .append('Access-Control-Allow-Headers', '*').append('Access-Control-Allow-Origin', '/**')
    .append('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS')}
    );
  }

 logout() {
    localStorage.removeItem('ACCESS_TOKEN');
  }
}
