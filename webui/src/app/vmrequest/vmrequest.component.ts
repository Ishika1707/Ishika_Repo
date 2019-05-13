import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {VmrequestService } from './vmrequest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vmrequest',
  templateUrl: './vmrequest.component.html',
  styleUrls: ['./vmrequest.component.css']
})
export class VmrequestComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private vmService: VmrequestService, private router: Router) { }
  registerVMForm: FormGroup;
  username: String;
  response : any;

  ngOnInit() {
    this.registerVMForm  =  this.formBuilder.group({
        vmname: ['', Validators.required],
        os: ['', Validators.required],
        cpu: ['', Validators.required],
        ram: ['', Validators.required],
        harddisk: ['', Validators.required],
        purpose: ['']
    });
  }

  get formControls() { return this.registerVMForm.controls; }

  onSubmit() {
    console.log('VM request called');
    console.log(this.registerVMForm.value);
    this.username = localStorage.getItem ('USERNAME');
    this.vmService.createUser(this.registerVMForm.value, this.username).subscribe(response => {
      alert(response.message);
      this.router.navigateByUrl('/welcome');
    },
    error => {
                console.error(error);
            }
    );
  }

}
