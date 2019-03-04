export class Wallet {
    constructor(private _walletTranId:number, private _walletPaymentMethod:string, private _walletCurrentBalance:number, private _walletTransStatus:string,
                private _customerId:number) {

    }
    set walletTranId(walletTranId:number) {
        this._walletTranId = walletTranId;
    }
    get walletTranId():number {
        return this._walletTranId;
    }
    set walletPaymentMethod(walletPaymentMethod:string) {
        this._walletPaymentMethod = walletPaymentMethod;
    }
    get walletPaymentMethod():string {
        return this._walletPaymentMethod;
    }
    set walletCurrentBalance(walletCurrentBalance:number) {
        this._walletCurrentBalance = walletCurrentBalance;
    }
    get walletCurrentBalance():number {
        return this._walletCurrentBalance;
    }
    set walletTransStatus(walletTransStatus:string) {
        this._walletTransStatus = walletTransStatus;
    }
    get walletTransStatus():string {
            return this._walletTransStatus;
    }
    set customerId(customerId:number) {
            this._customerId = customerId;
    }
    get customerId():number {
        return this._customerId;
    }


}