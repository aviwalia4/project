import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './model/Customer';

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
  }

  