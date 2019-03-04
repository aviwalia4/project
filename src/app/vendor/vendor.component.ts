import { Component, OnInit } from '@angular/core';
import {VendorService } from 'src/app/vendor.service';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { Vendor } from 'src/app/model/Vendor';


@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit,OnDestroy {
private vendorService: VendorService;
private vendors: Vendor;
  constructor(vendorService:VendorService) { 
    this.vendorService = vendorService;
  }

  ngOnInit() {
    let venId = localStorage.getItem('venId');
    this.vendorService.getVendorById(venId)
    .subscribe(response=> {
    this.vendors = response[0];
    console.log('vendors things');
    console.log(this.vendors)
});
  }
  ngOnDestroy(){
    console.log('Called before destroying the component...');
  }
} 