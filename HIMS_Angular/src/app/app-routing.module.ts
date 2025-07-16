import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAgentComponent } from './agent/add-agent/add-agent.component';
import { EditAgentComponent } from './agent/edit-agent/edit-agent.component';
import { HomeAgentComponent } from './agent/home-agent/home-agent.component';
import { ListAgentComponent } from './agent/list-agent/list-agent.component';
import { AddPolicyComponent } from './policy/add-policy/add-policy.component';
import { EditPolicyComponent } from './policy/edit-policy/edit-policy.component';
import { ListPolicyComponent } from './policy/list-policy/list-policy.component';
import { AddPolicyholderComponent } from './policyholder/add-policyholder/add-policyholder.component';
import { EditPolicyholderComponent } from './policyholder/edit-policyholder/edit-policyholder.component';
import { HomeComponent } from './policyholder/home/home.component';
import { ListPolicyholderComponent } from './policyholder/list-policyholder/list-policyholder.component';
import { PolicyComponent } from './policyholder/policy/policy.component';
import { ProfileComponent } from './policyholder/profile/profile.component';
import { PropertyComponent } from './policyholder/property/property.component';
import { QuoteComponent } from './policyholder/quote/quote.component';
import { AddPropertyComponent } from './property/add-property/add-property.component';
import { ListPropertyComponent } from './property/list-property/list-property.component';
import { AddQuoteComponent } from './quote/add-quote/add-quote.component';
import { EditQuoteComponent } from './quote/edit-quote/edit-quote.component';
import { ListQuoteComponent } from './quote/list-quote/list-quote.component';
import { AboutComponent } from './user/about/about.component';
import { AddUserComponent } from './user/add-user/add-user.component';
import { AdminComponent } from './user/admin/admin.component';
import { ContactUsComponent } from './user/contact-us/contact-us.component';
import { ForgotPasswordComponent } from './user/forgot-password/forgot-password.component';
import { GalleryComponent } from './user/gallery/gallery.component';
import { HomeUserComponent } from './user/home-user/home-user.component';
import { ListUserComponent } from './user/list-user/list-user.component';
import { LoginComponent } from './user/login/login.component';

const routes: Routes = [
  { path: 'add-policyholder', component: AddPolicyholderComponent},
  { path: 'edit-policyholder', component: EditPolicyholderComponent},
  { path: 'list-policyholder', component: ListPolicyholderComponent},
  { path: 'policyholder', component: HomeComponent},
  { path: 'add-property', component: AddPropertyComponent},
  { path: 'list-property', component: ListPropertyComponent},
  { path: 'add-quote', component: AddQuoteComponent},
  { path: 'edit-quote', component: EditQuoteComponent},
  { path: 'list-quote', component: ListQuoteComponent},
  { path: 'list-agent', component: ListAgentComponent},
  { path: 'add-agent', component: AddAgentComponent},
  { path: 'edit-agent', component: EditAgentComponent},
  { path: 'home-agent', component: HomeAgentComponent},
  { path: 'home-user', component: HomeUserComponent},
  { path: 'add-user', component: AddUserComponent },
  { path: 'list-user', component: ListUserComponent},
  { path: '', component: LoginComponent},
  { path: 'add-policy', component: AddPolicyComponent},
  { path: 'edit-policy', component: EditPolicyComponent},
  { path: 'list-policy', component: ListPolicyComponent},
  { path: 'admin', component: AdminComponent},
  { path: 'profile', component: ProfileComponent},
  { path: 'policy', component: PolicyComponent},
  { path: 'quote', component: QuoteComponent},
  { path: 'property', component: PropertyComponent},
  { path: 'contact-us', component: ContactUsComponent},
  { path: 'about', component: AboutComponent},
  { path: 'gallery', component: GalleryComponent},
  { path: 'forgot-password', component: ForgotPasswordComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
