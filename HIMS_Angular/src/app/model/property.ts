import { Quote } from "./quote";


export class Property {
    id: number;
    propertyId: number;
    marketValue: number;
    yearBuilt: number;
    squareFootage: number;
    dwellingStyle: DoubleRange;
    roofMaterial: string;
    garageType: string;
    fullBathCount: number;
    halfBathCount: number;
    hasSwimmingPool: boolean;
    quote: Quote;

    constructor(id: number, propertyId: number, marketValue: number, yearBuilt: number, squareFootage: number, dwellingStyle: DoubleRange, roofMaterial: string, garageType: string, fullBathCount: number, halfBathCount: number, hasSwimmingPool: boolean, quote: Quote) {
        this.id = id;
        this.propertyId = propertyId;
        this.marketValue = marketValue;
        this.yearBuilt = yearBuilt;
        this.squareFootage = squareFootage;
        this.dwellingStyle = dwellingStyle;
        this.roofMaterial = roofMaterial;
        this.garageType = garageType;
        this.fullBathCount = fullBathCount;
        this.halfBathCount = halfBathCount;
        this.hasSwimmingPool = hasSwimmingPool;
        this.quote = quote;
    }
}
