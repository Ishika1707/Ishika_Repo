import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router, private formBuilder: FormBuilder ) {}
  loginForm: FormGroup;
  isSubmitted  =  false;

  ngOnInit() {
  this.loginForm  =  this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', Validators.required]
    });
  }

  get formControls() { return this.loginForm.controls; }

    login() {
    console.log(this.loginForm.value);
    if (this.loginForm.invalid) {
      return;
    }
    this.loginService.login(this.loginForm.value).subscribe(response => {
        console.log(JSON.parse(response));
        console.log(response.user);
        console.log(response.vmList);
        localStorage.setItem('ACCESS_TOKEN', response.token);
        localStorage.setItem ('USERNAME', response.user.username);
        localStorage.setItem ('VMLIST', response.vmList);
        console.log('token' + localStorage.getItem ('ACCESS_TOKEN'));
        console.log('user' + localStorage.getItem ('USERNAME'));
        console.log('vmlist' + localStorage.getItem ('VMLIST'));
        this.router.navigateByUrl('/welcome');
    },
    error => {
                    console.error(error);

    });
  }

  backToHome() {
    console.log('redirected to home');
    this.router.navigateByUrl('/home');
  }

}
