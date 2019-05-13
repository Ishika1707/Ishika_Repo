import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
    username: any;
    vmdata: [];

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
      this.username = localStorage.getItem('USERNAME');
      console.log('inside welcome init:' + this.username);
  }
    logout() {
    this.loginService.logout();
    this.router.navigateByUrl('/');
  }

  requestVMform() {
    this.router.navigateByUrl('/request');
  }

}
