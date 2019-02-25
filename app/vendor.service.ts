import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VendorService {
vendor;
  constructor() { 
   this.vendor = [
     {
     id:1,
     phone:"9914475592",
     venBal:2000,
     email:"vijay@gmail.com"
  },
   ];

}
 getVendor() {
  return this.vendor; 
}
}
