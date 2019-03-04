import { Component, OnInit } from '@angular/core';
import {VendorService } from 'src/app/vendor.service';
import { Orders } from '../model/Orders';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendor-orders',
  templateUrl: './vendor-orders.component.html',
  styleUrls: ['./vendor-orders.component.css']
})
export class VendorOrdersComponent implements OnInit {
  private vendorService: VendorService;
  private comments:String;
  private vendorOrd;
  constructor(vendorService:VendorService,private router:Router) { 
    this.vendorService = vendorService;
  }
  ngOnInit() {
    let venId = localStorage.getItem('venId'); 
    this.vendorService.getOrdersByVendorId(venId)
    .subscribe(response=> {
      this.vendorOrd = response;
      console.log('vendor order things');
      console.log(this.vendorOrd)
    })


  }
  orderApproved(vendorOrd, comments){
    alert("ORDER APPROVED");
    //let status = "pending"//let status = localStorage 
    let venId = localStorage.getItem('venId'); 
    //let ordId = localStorage.getItem('ordId'); 
    this.comments = comments;

    console.log('hello' +this.comments);
    this.vendorService.updatePendingOrders(venId, vendorOrd.orderId, "APPROVED", this.comments).subscribe(response=>{
      console.log('order updated');
    })
    console.log('came inside the approved');
    console.log('came inside the approved' +vendorOrd.orderId);
    var orderStatus = vendorOrd.orderStatus;
    }
    orderRejected(vendorOrd, comments){
      alert("ORDER REJECTED");
     // let status = "pending"//let status = localStorage 
      let venId = localStorage.getItem('venId');
      this.comments = comments;

      console.log("Alll Data>>>>>>" +this.comments);
      // let ordId = localStorage.getItem('ordId');
      console.log('hello'  +vendorOrd.orderId);
      this.vendorService.updatePendingOrders(venId, vendorOrd.orderId, "REJECTED", this.comments).subscribe(response=>{
        console.log('order rejected');
      })
      console.log('came inside the reject ');
      console.log('came inside the reject'  +vendorOrd.orderId);
      var orderStatus = vendorOrd.orderStatus;
      this.router.navigate(['/vendor', venId,'dashboard']);
      }
  p:number=1;
}
