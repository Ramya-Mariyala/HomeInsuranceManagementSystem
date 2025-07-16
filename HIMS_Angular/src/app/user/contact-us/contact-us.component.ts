import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onFeedback() {
    let firstName = (document.getElementById('fName') as HTMLInputElement).value;
    let lastName = (document.getElementById('lName') as HTMLInputElement).value;
    alert('Thanks for your love' + firstName + ' ' + lastName);
  }

}
