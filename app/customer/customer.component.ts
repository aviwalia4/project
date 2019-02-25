import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { Customer } from 'src/app/model/Customer';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit, OnDestroy {
  private customerService: CustomerService;
  private customers: Customer;

  constructor(customerService: CustomerService) {
    this.customerService = customerService;
   }

  ngOnInit() {
    let cusId = localStorage.getItem('cusId');
    this.customerService.getAllCustomers(cusId)
    .subscribe(response=> {
    this.customers = response[0];
    console.log('customers things');
    console.log(this.customers)
});
  }
  ngOnDestroy(){
    console.log('Called before destroying the component...');
  }

}

