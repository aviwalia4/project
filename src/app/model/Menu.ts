export class Menu {
    constructor(private _menItemId:number, private _menItemName:string, private _menFoodType:string, private _menCalories:number, private _venId:number, private _vendorName:string,private _menVenPrice:number,private _menVenRating:number) {

    }
    set menItemId(menItemId:number) {
        this._menItemId = menItemId;
    }
    get menItemId():number {
        return this._menItemId;
    }
    set menItemName(menItemName:string) {
        this._menItemName = menItemName;
    }
    get menItemName():string {
        return this._menItemName;
    }
    set menFoodType(menFoodType:string) {
        this._menFoodType = menFoodType;
    }
    get menFoodType():string {
        return this._menFoodType;
    }
    set menCalories(menCalories:number) {
        this._menCalories = menCalories;
    }
    get menCalories():number {
        return this._menCalories;
    }

    set venId(venId:number) {
        this._venId = venId;
    }
    get venId():number {
        return this._venId;
    }
    set vendorName(vendorName:string) {
        this.vendorName = vendorName;
    }
    get vendorName():string {
        return this._vendorName;
    }
    set menVenPrice(menVenPrice:number) {
        this._menVenPrice = menVenPrice;
    }
    get menVenPrice():number {
        return this._menVenPrice;
    }
    set menVenRating(menVenRating:number) {
        this._menVenRating = menVenRating;
    }
    get menVenRating():number {
        return this._menVenRating;
    }



}