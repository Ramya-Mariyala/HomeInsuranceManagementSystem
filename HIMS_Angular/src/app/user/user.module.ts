import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddUserComponent } from './add-user/add-user.component';
import { ListUserComponent } from './list-user/list-user.component';
import { LoginComponent } from './login/login.component';
import { HomeUserComponent } from './home-user/home-user.component';
import { UserService } from '../services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminComponent } from './admin/admin.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutComponent } from './about/about.component';
import { GalleryComponent } from './gallery/gallery.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';



@NgModule({
  declarations: [AddUserComponent , ListUserComponent, LoginComponent, HomeUserComponent, AdminComponent, ContactUsComponent, AboutComponent, GalleryComponent, ForgotPasswordComponent],
  imports: [
    CommonModule, HttpClientModule, AppRoutingModule, ReactiveFormsModule
  ],
  providers: [UserService]
})
export class UserModule { }
