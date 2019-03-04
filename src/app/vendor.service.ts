// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import { Vendor } from './model/Vendor';
// import { Menu } from './model/Menu';
// import { Orders } from './model/Orders';
// @Injectable({
//   providedIn: 'root'
// })
// export class VendorService {
//   private http:HttpClient;
//   vendorOrd: any;
//   constructor(http:HttpClient) {
//     this.http = http;
//   }
//   getVendorById(venId): Observable<Vendor[]>{
//     return this.http.get<Vendor[]>('http://localhost:8080/FTP111/api/vendors/'+venId);
//   }
//   getOrdersByVendorId(venId): Observable<Orders>{
//     return this.http.get<Orders>('http://localhost:8080/FTP111/api/vendors/'+venId+'/orderItem');
//   }
//   getOrders(venId): Observable<Orders>{
//     return this.http.get<Orders>('http://localhost:8080/FTP111/api/vendors/'+venId+'/orders');
//   }

//   authenticate(venId, venPassword):Observable<any>{
//   return this.http.post('http://localhost:8080/FTP111/api/vendors/auth',{"vendorId":venId,"venPass":venPassword})
//   }

//   updatePendingOrders(venId, ordId, status, comments):Observable<Orders[]>{
//   return this.http.put<Orders[]>('http://localhost:8080/FTP111/api/vendors/'+venId+'/orderItem/'+ordId, {"orderStatus":status, "comments":comments})
//   }
//      addItem(itemadd): Observable<Menu[]>{
//       return this.http.post<Menu[]>('http://localhost:8080/FTP111/api/vendors/'+itemadd.vendorId+'/menu',{"menFoodType":itemadd.foodType ,"menVegNonVeg":itemadd.catType,
//                                     "menItemName":itemadd.name, "menCalories":+itemadd.claories, "vendorId":+itemadd.id, "menVenPrice":+itemadd.price2});
//     }
// }




import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vendor } from './model/Vendor';
import { Menu } from './model/Menu';
import { Orders } from './model/Orders';
@Injectable({
  providedIn: 'root'
})
export class VendorService {
  private http:HttpClient;
  vendorOrd: any;
  constructor(http:HttpClient) {
    this.http = http;
  }
  getVendorById(venId): Observable<Vendor[]>{
    return this.http.get<Vendor[]>('http://localhost:8080/FTP111/api/vendors/'+venId);
  }
  getOrdersByVendorId(venId): Observable<Orders>{
    return this.http.get<Orders>('http://localhost:8080/FTP111/api/vendors/'+venId+'/orderItem');
  }
  getOrders(venId): Observable<Orders>{
    return this.http.get<Orders>('http://localhost:8080/FTP111/api/vendors/'+venId+'/orders');
  }

  authenticate(venId, venPassword):Observable<any>{
  return this.http.post('http://localhost:8080/FTP111/api/vendors/auth',{"vendorId":venId,"venPass":venPassword})
  }

  updatePendingOrders(venId, ordId, status, comments):Observable<Orders[]>{
  return this.http.put<Orders[]>('http://localhost:8080/FTP111/api/vendors/'+venId+'/orderItem/'+ordId, {"orderStatus":status, "comments":comments})
  }
     addItem(itemadd): Observable<Menu[]>{
      return this.http.post<Menu[]>('http://localhost:8080/FTP111/api/vendors/'+itemadd.vendorId+'/menu',{"menFoodType":itemadd.foodType ,"menVegNonVeg":itemadd.catType,
                                    "menItemName":itemadd.name, "menCalories":+itemadd.claories, "vendorId":+itemadd.id, "menVenPrice":+itemadd.price2});
    }
}


