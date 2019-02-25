import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Menu } from './model/Menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  private http:HttpClient;
  constructor(http:HttpClient) {
    this.http = http;
  }
   getAllMenu(): Observable<Menu[]>{
    return this.http.get<Menu[]>('http://localhost:8080/FTP111/api/menu');
  }
}