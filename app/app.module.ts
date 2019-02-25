import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
//import { OrdersComponent } from './orders/orders.component';
import { VendorComponent } from './vendor/vendor.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { CustomerComponent } from './customer/customer.component';
//import { WalletComponent } from './wallet/wallet.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { VendorDashboardComponent } from './vendor-dashboard/vendor-dashboard.component';

@NgModule({
  declarations: [
  AppComponent,
  MenuComponent,
  VendorComponent,
  //OrdersComponent,
  //WalletComponent,
  LoginComponent,
  CustomerComponent,
  CustomerDashboardComponent,
  VendorDashboardComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        'path':'',
        component:MenuComponent
      },
      {
        'path':'menu',
        component:MenuComponent
      },
      {
        'path':'customer/:id/dashboard',
        component:CustomerDashboardComponent,
      },
      {
        'path':'customer/:id/dashboard/details',
        component:CustomerComponent,
      },
      {
        'path':'vendor/:id/dashboard',
        component:VendorDashboardComponent,
      },
      {
        path:'vendor',
        component:VendorComponent
      },
      // {
      //   path:'orders',
      //   component:OrdersComponent
      // },
      // {
      //   path:'wallet',
      //   component:WalletComponent
      // },
      {
        path:'login',
        component:LoginComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }