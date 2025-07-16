import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Agent } from '../model/agent';





@Injectable({
    providedIn: 'root'
})
export class AgentService {
    constructor(private http: HttpClient) { }

    // for Json - Server uncomment following url
    baseUrl: string = 'http://localhost:9091/agents';

    // Get All Agents
    getAgents() {
        return this.http.get<Agent[]>(this.baseUrl + '/viewAllAgents');
    }
    // Get Agent By Id
    getAgentById(id: number) {
        return this.http.get<Agent>(this.baseUrl + '/agentById/' + id);
    }
    // Create Agent
    createAgent(agent: Agent): Observable<string> {
        return this.http.post(this.baseUrl + '/agent', agent, { responseType: 'text' });
    }
    // Modify Agent
    updateAgent(agent: Agent): Observable<string> {
        return this.http.put(this.baseUrl + '/agentUpdate/' + agent.agentId, agent, { responseType: 'text' });
    }
    // Delete Agent
    deleteAgent(id: number): Observable<string> {
        return this.http.delete(this.baseUrl + '/agentDelete/' + id, {responseType: 'text'});
    }
}