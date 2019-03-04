 import { Component, OnInit } from '@angular/core';
 import { CustomerService } from 'src/app/customer.service';
 import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
 
 @Component({
   selector: 'app-customerOrder',
   templateUrl: './customerOrder.component.html',
   styleUrls: ['./customerOrder.component.css']
 })
 export class CustomerOrderComponent implements OnInit,OnDestroy {

   private customerService:CustomerService;
   private customerOrder;

   constructor(customerService: CustomerService) {
     this.customerService = customerService;
    }


   ngOnInit() {
     let custId=localStorage.getItem('cusId');
     console.log(custId);
     this.customerOrder = this.customerService.getAllOrders(custId)
        .subscribe(response=> {
          this.customerOrder = response;
          console.log('orders history');
    console.log(this.customerOrder)})
     }
   ngOnDestroy() {
     console.log('Called before destroying the component...');
   }

  
   }

