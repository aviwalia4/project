import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { Wallet } from '../model/Wallet';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit, OnDestroy {

  private customerService:CustomerService;
  private wallet:Wallet[];

  constructor(customerService: CustomerService ) {
    this.customerService = customerService;
   }

  ngOnInit() {
    console.log('wallet details');
    let cusId = localStorage.getItem('cusId');
    this.customerService.getAllWallet(cusId)
    .subscribe(response=> {
      this.wallet = response;
      console.log('wallet details');
    console.log(this.wallet);
    })
  }
  ngOnDestroy(){
    console.log('Called before destroying the wallet component...');
  }
}
