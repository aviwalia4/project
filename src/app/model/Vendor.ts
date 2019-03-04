export class Vendor{
    constructor(private _vendorId:number, private _vendorName:string, private _vendorPhone:string, private _vendorAccNo:string,
        private _vendorBalance:number, private _vendorEmail:string,) {

    }
    set vendorId(vendorId:number) {
        this._vendorId = vendorId;
    }
    get vendorId():number {
        return this._vendorId;
    }
    set vendorName(vendorName:string) {
        this._vendorName = vendorName;
    }
    get vendorName():string {
        return this._vendorName;
    }
    set vendorPhone(vendorPhone:string) {
        this._vendorPhone = vendorPhone;
    }
    get vendorPhone():string {
        return this._vendorPhone;
    }
    set vendorAccNo(vendorAccNo:string) {
        this._vendorAccNo = vendorAccNo;
    }
    get vendorAccNo():string {
        return this._vendorAccNo;
    }
    set vendorBalance(vendorBalance:number) {
        this._vendorBalance = vendorBalance;
    }
    get vendorBalance():number {
        return this._vendorBalance;
    }
    set vendorEmail(vendorEmail:string) {
        this._vendorEmail = vendorEmail;
    }
    get vendorEmail():string {
        return this._vendorEmail;
    }
}