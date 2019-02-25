import { Component, OnInit } from '@angular/core';
import {VendorService } from 'src/app/vendor.service';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';


@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit,OnDestroy {
private vendorService: VendorService;
private vendor; 
  constructor(vendorService:VendorService) { 
    this.vendorService = vendorService;
  }

  ngOnInit() {
    this.vendor = this.vendorService.getVendor();
  }
  ngOnDestroy(){
    console.log('Called before destroying the component...');
  }
}