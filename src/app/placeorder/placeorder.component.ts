import { Component, OnInit, ɵConsole } from '@angular/core';
import { MenuService } from '../menu.service';
import { Menu } from '../model/Menu';
import { Vendor } from '../model/Vendor';
import { CustomerService } from '../customer.service';
import { Wallet } from '../model/Wallet';
import { Orders } from '../model/Orders';
import { Router } from '@angular/router';

@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css']
})
export class PlaceorderComponent implements OnInit {

  constructor( private menuService:MenuService, private customerService:CustomerService, private router:Router) {}
    private menu;
    private vendors:Vendor[];
    private qty: number;
    private wallet:Wallet[];
    private vendorId:number;
    private menItemId:number;
    private totalPrice:number;
    private selectedMenu;
    private foodId:number;
    private AvailableWallets:Wallet[];
    private totalWalletBalance:number;
    selectedwallet;
    private availaleBal:number;
    private dumvalidWallets:Wallet[];
    private value:number;

  ngOnInit() {
    let cusId = localStorage.getItem('cusId');
    this.menuService.getAllMenu()
    .subscribe(response=> {
      this.menu = response;
      console.log('came inside>>>>',this.menu);
    })
    this.customerService.getAllWallet(localStorage.getItem('cusId'))
    .subscribe(wallet=> this.wallet = wallet)
    console.log('came inside the ...');
}

  onMenuSelected(onMenuSelected) {
    this.menuService.findByMenItemId(onMenuSelected).subscribe(vendors => this.vendors = vendors);
    console.log(' menu item selected ', onMenuSelected);
    this.menItemId = +onMenuSelected;
    console.log(' menu item have taken ', onMenuSelected);

  }

 selectedVendor(selectedVendorId) {
    console.log('came inside the selected vendor....',selectedVendorId);
    this.vendorId = +selectedVendorId;
}

selectedQty(selectedQuantity) {
  let cusId = localStorage.getItem('cusId');
  let qty = selectedQuantity;
  console.log("quantity>>>",qty);
  let foodId = this.menItemId;
  console.log("food id>>>",this.menItemId);
  let vendorId = this.vendorId;
  console.log('vendor id', +vendorId);
  console.log(this.menu);
  console.log(this.menu.filter(menu =>menu.vendorId === vendorId && menu.menItemId === foodId));
  this.selectedMenu = this.menu.filter(menu =>menu.vendorId === vendorId && menu.menItemId === this.menItemId);
  console.log("selected >>>",this.selectedMenu);
  console.log("selected menu >>>"+this.selectedMenu[0].menVenPrice);
  console.log("quantity"+qty);
  this.totalPrice = this.selectedMenu[0].menVenPrice * qty;
  console.log("total price"+this.totalPrice);
  console.log("Wallet "+this.wallet)
  console.log(this.wallet.filter(wallet =>wallet.walletCurrentBalance > this.totalPrice));
  this.AvailableWallets = this.wallet.filter(wallet =>wallet.walletCurrentBalance > this.totalPrice);
  console.log('wallet valids ones');
  console.log(this.AvailableWallets);
}

selectedWallet(selectedwallet){
    let selectedWallet = selectedwallet.value;
    console.log("Seleted Wallet"+ selectedWallet);
    let dumTotal = this.totalPrice;
    console.log("Seleted Wallet=========="+ this.wallet);
    console.log(this.wallet.filter(wallet =>wallet.walletTranId === +selectedWallet));
    this.dumvalidWallets = this.wallet.filter(wallet =>wallet.walletTranId === +selectedWallet);
    this.value = this.wallet[0].walletTranId-dumTotal;
    console.log("Dummy value of after Calculation"+this.value);
  }

  submitForm(form){
    console.log('form');
    console.log(form);
     let foodId = form.value.menu;
    console.log('food', +form.value.menu);
     let vendorId = form.value.vendor;
     console.log('s the ven', +vendorId );
     let cusId = localStorage.getItem('cusId');
     console.log("CUSTOMER ID in form>>"+cusId)
     let qty = form.value.selectedQuantity;
     let totalPrice = this.totalPrice;
     let selectedWallet = form.value.selectedwallet;
     console.log("Seleted Wallet in form "+selectedWallet);
     let orders:any = {};
     orders.quantity = qty;
     console.log('placing the order quan ',+orders.quantity);
    orders.vendorId= vendorId;
    console.log('placing the ven', +orders.vendorId );
    orders.foodId=foodId;
    console.log('placing the food',+orders.foodId );
    orders.cusId = cusId;
    orders.walTransId=selectedWallet;
    orders.OrdTotalPrice=totalPrice;
    console.log('placing the customer ',+orders.cusId);
     console.log(orders);
    this.customerService.placeOrder(orders).subscribe(res=>{
     console.log("Order Placed");
     alert("CONGRATULATIONS ORDER PLACED");
    this.router.navigate(['/customer', cusId,'dashboard']);
    });
  }
}
