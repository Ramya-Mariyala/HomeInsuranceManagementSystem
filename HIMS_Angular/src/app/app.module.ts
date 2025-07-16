import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PolicyholderModule } from './policyholder/policyholder.module';
import { PropertyModule } from './property/property.module';
import { QuoteModule } from './quote/quote.module';
import { AgentModule } from './agent/agent.module';
import { UserModule } from './user/user.module';
import { PolicyModule } from './policy/policy.module';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, PolicyholderModule, PropertyModule, QuoteModule, AgentModule, UserModule, PolicyModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
