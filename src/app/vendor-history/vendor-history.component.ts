import { Component, OnInit } from '@angular/core';
import {VendorService } from 'src/app/vendor.service';


@Component({
  selector: 'app-vendor-history',
  templateUrl: './vendor-history.component.html',
  styleUrls: ['./vendor-history.component.css']
})
export class VendorHistoryComponent implements OnInit {
  private vendorService: VendorService;
  private vendorHistory;
  constructor(vendorService:VendorService) { 
    this.vendorService = vendorService;
  }
  ngOnInit() {
    let venId = localStorage.getItem('venId'); 
    this.vendorService.getOrders(venId)
    .subscribe(response=> {
      this.vendorHistory = response;
      console.log('vendor history things');
      console.log(this.vendorHistory)
    })
  }
  p:number=1;

}
