export class Menu {
    constructor(private _menItemId:number, private _menItemName:string, private _menFoodType:string, private _menCalories:number) {

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


}