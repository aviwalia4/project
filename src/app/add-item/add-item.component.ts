import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  constructor(private vendorService:VendorService) { }
private ittype;
private vegNveg;
private itname;
private cal:number;
private vendrid:number;
private price1:number;
  ngOnInit() {
    let venId = localStorage.getItem('venId');
  }

menFoodType(ItemFoodType) {
  this.ittype = ItemFoodType;
    console.log("item Type>>>", this.ittype);
}
menVegNonVeg(itemVegNonVeg) {
  this.vegNveg = itemVegNonVeg;
    console.log("item veg/nVeg>>>", this.vegNveg);
}
addName(addItemName) {
  this.itname = addItemName;
    console.log("item Name>>>", this.itname);
}
addCalories(addItemCalories) {
  this.cal = addItemCalories;
    console.log("item calories>>>", this.cal);
}
venId(venItemId) {
  this.vendrid = venItemId;
    console.log("item vendrid>>>", this.vendrid);
}
price(itemPrice) {
  this.price1 = itemPrice;
    console.log("item price>>>", this.price1);
}

    submitForm(form) {
      console.log("entered");
  let ittype = this.ittype;
    console.log("item Type>>>", ittype);
  let vegNveg = this.vegNveg;
    console.log("item veg/nVeg>>>", vegNveg);
    console.log('item name');
  let itname = this.itname;
      console.log("item Name>>>", itname);
  let cal = this.cal;
    console.log("item calories>>>", cal);
  let vendrid = this.vendrid;
    console.log("item vendrid>>>", vendrid);
  let price2 = this.price1;
    console.log("item price>>>", price2);
  let itemadd:any = {};
     itemadd.foodType = ittype;
    console.log("ITEM type", itemadd.foodType);
               itemadd.catType = vegNveg;
          console.log("ITEM v/nV", itemadd.catType);
               itemadd.name = itname;
          console.log("ITEM name", itemadd.name);
               itemadd.claories = cal;
          console.log("ITEM claories", +itemadd.claories);
               itemadd.id = vendrid;
          console.log("ITEM vendor id", +itemadd.id);
               itemadd.price2 = price2;
          console.log("ITEM price", +itemadd.price2);
          console.log(itemadd);
    this.vendorService.addItem(itemadd).subscribe(res=>{
     console.log("ITEM ADDED");
     alert("CONGRATULATIONS ITEM ADDED");

    });
  }
}

