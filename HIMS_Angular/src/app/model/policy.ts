import { Quote } from "@angular/compiler";

export class Policy {
    id: number;
    policyId: number;
    policyEffectiveDate: string;
    policyEndDate: string;
    policyTerm: number;
    policyStatus: string;
    quote:Quote;

    constructor(id: number, policyId: number, policyEffectiveDate: string, policyEndDate: string, policyTerm: number, policyStatus: string,quote:Quote) {
        this.id = id;
        this.policyId = policyId;
        this.policyEffectiveDate = policyEffectiveDate;
        this.policyEndDate = policyEndDate;
        this.policyStatus = policyStatus;
        this.policyTerm = policyTerm;
        this.quote=quote;
    }
}