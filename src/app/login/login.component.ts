import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { VendorService } from '../vendor.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router, private customerService:CustomerService, private vendorService:VendorService) { }
  private errorMessage;
  ngOnInit() {
  }
  customersubmit(form) {
    console.log('came inside the submit method');
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
    console.log('came inside the submit method');
    let venId = form2.value.vid;
    let vPass = form2.value.vPass;
    console.log('came inside the pass method');
    if (form2.valid) {
      this.vendorService.authenticate(venId, vPass)
      .subscribe(response=> {
        this.router.navigate(['/vendor',form2.value.vid, 'dashboard']);
      }, (error)=>{
          this.errorMessage="Invalid Login credentials";
      });
    }
  }

  handle(id){
    console.log('clicked with ', id);
  }
}