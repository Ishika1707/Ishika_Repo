import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class WelcomeService {
  display = false;
  constructor(private http: HttpClient) {}

  getVmData(user: any): Observable<any> {
    console.log('getting vm data for user ' + user.username);
    return this.http.get('http://localhost:8080/getVmData?username=' + user.username,
      {headers: new HttpHeaders().set('Content-Type', 'application/json' )
    .append('Access-Control-Allow-Headers', '*').append('Access-Control-Allow-Origin', '/**')
    .append('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS')}
    );
  }

}
