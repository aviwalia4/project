import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './model/customer';
import { Orders } from './model/Orders';
import { Wallet } from './model/Wallet';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private http:HttpClient;
  constructor(http:HttpClient) {
    this.http = http;
  }
   getAllCustomers(cusId): Observable<Customer[]>{
    console.log(cusId)
    return this.http.get<Customer[]>('http://localhost:8080/FTP111/api/customers/'+cusId);
   }

   authenticate(custId, password):Observable<any>{
     return this.http.post('http://localhost:8080/FTP111/api/customers/auth',{"customerId":custId,"customerPass":password})
   }
   getAllOrders(cusId): Observable<Orders[]>{
     return this.http.get<Orders[]>('http://localhost:8080/FTP111/api/customers/'+cusId+'/orders');
    }

    getAllWallet(cusId): Observable<Wallet[]>{
      return this.http.get<Wallet[]>('http://localhost:8080/FTP111/api/customers/'+cusId+'/wallets');
    }
    placeOrder(orders): Observable<Orders[]>{
      return this.http.post<Orders[]>('http://localhost:8080/FTP111/api/customers/'+orders.foodId+'/orders/'+orders.quantity,{"cusId":+orders.cusId,"venId":+orders.vendorId,"walTransId":+orders.walTransId,"orderTotalPrice":+orders.OrdTotalPrice});
    }
  }
