import { Component, OnInit, ViewChild, ViewChildren, TemplateRef, ViewContainerRef, ViewEncapsulation, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {UserService } from '../user/user.service';
import { User } from './user';
import { UserResponse } from './userResponse';
//import * as $ from "jquery";
// * as bootstrap from "bootstrap";
//import {NgbModule, NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

//declare let $: JQueryStatic;

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  styles: [`
    .dark-modal .modal-content {
      background-color: pink;
      color: white;
    }

  `]
})
export class UserComponent implements OnInit {

  // @ViewChild('content')
  // private contentTempRef : TemplateRef<any>
  // private viewContainer: ViewContainerRef

  constructor(private router: Router, private formBuilder: FormBuilder, private userService: UserService) { }
  registerForm: FormGroup;
  submitted  =  false;
  showSucessModal = false;
  closeResult: string;
  response: UserResponse;

  open(content: any) {
    console.log('inside open content');
    console.log(content);
    // this.modalService.open(content, { windowClass: 'dark-modal', size: 'sm'});
    // this.viewContainer.createEmbeddedView(this.contentTempRef);
  }


  ngOnInit() {
    this.registerForm  =  this.formBuilder.group({
        username: ['', Validators.required],
        country: ['', Validators.required],
        designation: ['', Validators.required],
        password: ['', Validators.required],
        mobileNumber: ['']
    });
    console.log('inside ng-init');
  }

  get formControls() { return this.registerForm.controls; }

  onSubmit() {
    console.log('This is called');
    console.log(this.registerForm.value);
    this.submitted = true;
    this.userService.createUser(this.registerForm.value).subscribe(response => {
      // if (response !== null) {
          alert(response.message);
         this.router.navigateByUrl('/login');
      // } else {
          // alert ('User with username already present');
          // this.registerForm.reset();
      // }

    },
    error => {
                    alert('Cannot login because: '+error);
                    console.error(error);
                });
    }

    routeToLogin() {
      this.router.navigateByUrl('/login');
    }

}



