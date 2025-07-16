export class HomeAddress{
    id: number;
    residenceType: string;
    addressLine1: string;
    addressLine2: string;
    city: string;
    state: string;
    zip: string;
    residenceUse: string;

    constructor(id: number, residenceType: string, addressLine1: string, addressLine2: string, city: string, state: string, zip: string, residenceUse: string){

        this.id = id;
        this.residenceType = residenceType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.residenceUse = residenceUse;
    }
}