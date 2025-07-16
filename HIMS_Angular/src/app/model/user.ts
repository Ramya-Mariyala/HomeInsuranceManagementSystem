import { Agent } from "./agent";
import { PolicyHolder } from "./policyholder";

export class User {
    userName: string;
    password: string;
    role: string;
    agent: Agent;
    policyHolder: PolicyHolder;

    constructor(userName: string, password: string, role: string, agent: Agent, policyHolder: PolicyHolder) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.agent = agent;
        this.policyHolder = policyHolder;
    }


}
