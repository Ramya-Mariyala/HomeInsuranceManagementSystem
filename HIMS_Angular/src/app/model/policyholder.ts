import { HomeAddress } from "./homeaddress";
import { Policy } from "./policy";



export class PolicyHolder {
    id: number;
    policyHolderId: number;
    policyHolderName: string;
    policyName: string;
    premiumType: string;
    creditCard: string;
    dob: string;
    occupation: string;
    annualIncome: string;
    isRetired: string;
    ssn: string;
    emailId: string;
    address: HomeAddress;
    policyId: Policy;

    constructor(id: number, policyHolderId: number, policyHolderName: string, policyName: string, premiumType: string, creditCard: string, dob: string, occupation: string, annualIncome: string, isRetired: string, ssn: string, emailId: string, address: HomeAddress, policyId: Policy) {

        this.id = id;
        this.policyHolderId = policyHolderId;
        this.policyHolderName = policyHolderName;
        this.policyName = policyName;
        this.premiumType = premiumType;
        this.creditCard = creditCard;
        this.dob = dob;
        this.occupation = occupation;
        this.annualIncome = annualIncome;
        this.isRetired = isRetired;
        this.ssn = ssn;
        this.emailId = emailId;
        this.address = address;
        this.policyId = policyId;
    }

}