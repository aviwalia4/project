export class Orders {
  static OrdStatus: any;
    constructor(private _orderId:number, private _cusId:number, private _walTransId: number, private _OrdStatus: string,
                private _OrdDateTime: Date, private _comments: string,  private _ordStatus:string, private _OrdTotalPrice: number,
                private _menItemId:number, private _quantity:number, private _vendorId:number, private _vendorName:string) {
    }
    set orderId(orderId:number) {
        this._orderId = orderId;
    }
    get orderId():number {
        return this._orderId;
    }

    set cusId(cusId:number) {
        this._cusId = cusId;
    }
    get cusId():number {
        return this._cusId;
    }
    set walTransId(walTransId:number) {
        this._walTransId = walTransId;
    }
    get walTransId():number {
        return this._walTransId;
    }
    set OrdTotalPrice(OrdTotalPrice:number) {
        this._OrdTotalPrice = OrdTotalPrice;
    }
    get OrdTotalPrice():number {
        return this._OrdTotalPrice;
    }
    set OrdDateTime(OrdDateTime:Date) {
        this._OrdDateTime = OrdDateTime;
    }
    get OrdDateTime():Date {
        return this._OrdDateTime;
    }
    // set VendorId(VendorId:number) {
    //     this._VendorId = VendorId;
    // }
    // get VendorId():number {
    //     return this._VendorId;
    // }
    set OrdStatus(OrdStatus:string) {
        this._OrdStatus = OrdStatus;
    }
    set vendorName(vendorName:string) {
        this._vendorName = vendorName;
    }
    get OrdStatus():string {
        return this._OrdStatus;
    }
    set comments(comments:string) {
        this._comments = comments;
    }
    get comments():string {
        return this._comments;
    }
     set vendorId(vendorId:number) {
        this._vendorId = vendorId;
    }
    get vendorId():number {
        return this._vendorId;
    }
    set ordStatus(ordStatus:string) {
        this._ordStatus = ordStatus;
    }
    get ordStatus():string {
        return this._ordStatus;
    }
    get vendorName():string {
        return this._vendorName;
    }
     set quantity(quantity:number) {
     this._quantity = quantity;
     }
     get quantity():number {
     return this._quantity;
     }
    set menItemId(menItemId:number) {
    this._menItemId = menItemId;
    }
     get menItemId():number {
         return this._menItemId;
   }
}
