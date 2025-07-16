import { Property } from "./property";

export class Quote {
    id: number;
    quoteId: number;
    premiumType: string;
    premium: DoubleRange;
    dwellingCoverage: DoubleRange;
    detachedStructureCoverage: DoubleRange;
    personalPropertyCoverage: DoubleRange;
    additionalLivingExpense: DoubleRange;
    medicalExpense: DoubleRange;
    deductableAmount: DoubleRange;
    property: Property;

    constructor(id: number, quoteId: number, premiumType: string, premium: DoubleRange, dwellingCoverage: DoubleRange, detachedStructureCoverage: DoubleRange, personalPropertyCoverage: DoubleRange, additionalLivingExpense: DoubleRange, medicalExpense: DoubleRange, deductableAmount: DoubleRange,property: Property) {
        this.id = id;
        this.quoteId = quoteId;
        this.premiumType = premiumType;
        this.premium = premium;
        this.dwellingCoverage = dwellingCoverage;
        this.detachedStructureCoverage = detachedStructureCoverage;
        this.personalPropertyCoverage = personalPropertyCoverage;
        this.additionalLivingExpense = additionalLivingExpense;
        this.medicalExpense = medicalExpense;
        this.deductableAmount = deductableAmount;
        this.property = property;
    }
}
