export class Customer {
    constructor(private _customerId:number, private _customerName:string, private _customerPhone:string, private _customerEmail:string) {
    }
    set customerId(customerId:number) {
        this._customerId = customerId;
    }
    get customerId():number {
        return this._customerId;
    }
    set customerName(customerName:string) {
        this._customerName = customerName;
    }
    get customerName():string {
        return this._customerName;
    }
    set customerPhone(customerPhone:string) {
        this._customerPhone = customerPhone;
    }
    get customerPhone():string {
        return this._customerPhone;
    }
    set customerEmail(customerEmail:string) {
        this._customerEmail = customerEmail;
    }
    get customerEmail():string {
        return this._customerEmail;
    }
}