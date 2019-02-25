import { Component, OnInit } from '@angular/core';
import {RouterModule, Router} from '@angular/router';
import { CustomerService } from '../customer.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router, private customerService:CustomerService) { }
  private errorMessage;
  ngOnInit() {
  }
  customersubmit(form) {
    console.log('came inside teh submit method');
    let custId = form.value.id;
    let password = form.value.password;
    if (form.valid) {
      this.customerService.authenticate(custId, password)
      .subscribe(response=> {
        this.router.navigate(['/customer',form.value.id, 'dashboard']);
      }, (error)=>{
         this.errorMessage="Invalid Login credentials";
      });
    }
  }
    vendorsubmit(form2) {
      console.log(form2.value.vid);
      console.log(form2.value.vpassword);
      if (form2.valid) {
        this.router.navigate(['/vendor',form2.value.vid, 'dashboard']);
      }

  }

}
