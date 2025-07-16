import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddQuoteComponent } from './add-quote/add-quote.component';
import { EditQuoteComponent } from './edit-quote/edit-quote.component';
import { ListQuoteComponent } from './list-quote/list-quote.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { QuoteService } from '../services/quote.service';



@NgModule({
  declarations: [AddQuoteComponent, EditQuoteComponent, ListQuoteComponent],
  imports: [
    CommonModule, ReactiveFormsModule, HttpClientModule, AppRoutingModule
  ],
  providers: [QuoteService]
})
export class QuoteModule { }
