
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { CustomerOrderComponent } from './CustomerOrder/CustomerOrder.component';
import { VendorComponent } from './vendor/vendor.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { CustomerComponent } from './customer/customer.component';
import { WalletComponent } from './wallet/wallet.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { VendorDashboardComponent } from './vendor-dashboard/vendor-dashboard.component';
import { VendorOrdersComponent } from './vendor-orders/vendor-orders.component';
import { VendorHistoryComponent } from './vendor-history/vendor-history.component';
import { PlaceorderComponent } from './placeorder/placeorder.component';
import { AddItemComponent } from './add-item/add-item.component';
// import { MenuDashboardComponent } from './menu-dashboard/menu-dashboard.component';
// import { CustomerBillComponent } from './customer-bill/customer-bill.component';
import { NgxPaginationModule} from 'ngx-pagination';
const routes: Routes = [
]
@NgModule({
  declarations: [
  AppComponent,
  MenuComponent,
  VendorComponent,
  CustomerOrderComponent,
  WalletComponent,
  LoginComponent,
  CustomerComponent,
  CustomerDashboardComponent,
  VendorDashboardComponent,
  VendorOrdersComponent,
  VendorHistoryComponent,
  PlaceorderComponent,
  AddItemComponent,

  // MenuDashboardComponent,
  // CustomerBillComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    RouterModule.forRoot([
      {
        'path':'',
        component:MenuComponent
      },
      {
        'path':'menu',
        component:MenuComponent,
      },
      {
        'path':'customer/:id/dashboard',
        component:CustomerDashboardComponent,
        children :[
          {
            path:'',redirectTo: 'details', pathMatch: 'prefix' ,

          },
          {
            path:'details',
            component:CustomerComponent,
          },
          {
            path:'customerOrder',
            component:CustomerOrderComponent
         },
         {
          path:'walletdetails',
          component:WalletComponent,
        },
        {
          path:'placeorder',
          component:PlaceorderComponent,
        }
        ]
      },
      {
        'path':'vendor/:id/dashboard',
        component:VendorDashboardComponent,
        children :[
          {
            path:'',redirectTo: 'venordetails', pathMatch: 'prefix' ,

          },
          {
            path:'vendordetails',
            component:VendorComponent,
          },
          {
            path:'vendorHistory',
            component:VendorHistoryComponent,
          },
          {
            path:'vendororderdetails',
            component:VendorOrdersComponent,
          },
          {
            path:'addItem',
           component:AddItemComponent
      }
        ]
      },
      {
        path:'login',
        component:LoginComponent
      },

      {
        path:'menuByVendor',
        component:MenuComponent,
      },
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }