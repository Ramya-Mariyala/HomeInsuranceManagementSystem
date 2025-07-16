export class Agent {
    id: number;
    agentId: number;
    agentName: string;
    designation: string;
    salary: string;
    address: string;
    email: string;
    mobileNo: string;
 
   constructor(id:number, agentId:number, agentName: string, designation: string, salary: string, address: string, email: string, mobileNo: string){
       this.id = id;
       this.agentId = agentId;
       this.agentName = agentName;
       this.designation = designation;
       this.salary = salary;
       this.address = address;
       this.email = email;
       this.mobileNo = mobileNo;
   }
}