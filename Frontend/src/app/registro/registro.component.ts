//  Basics
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet, RouterLinkActive } from '@angular/router';
import { APIrestService } from "../service/form-request.service";
import { FormsModule } from "@angular/forms";
import { ReactiveFormsModule } from '@angular/forms';

// pages components
import { NavBarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive, NavBarComponent, FooterComponent, FormsModule, ReactiveFormsModule],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})

export class RegistroComponent {

//   data: any[] = [];

//   userData = {
//     name: '',
//     lastname: '',
//     tel: '',
//     email: '',
//     address: '',
//     user: '',
//     pass: '',
//   };

//   constructor(public APIrestService: APIrestService) { }

// ApiData() {
//   this.APIrestService.getData().subscribe(data => {
//     this.data = data;
//     console.log(this.data);
//   },
//     error => {
//       console.error('Error al obtener datos:', error);
//     }
//   )
// }

// submitForm(form: any): void {
//   if(form.valid) {
//   console.log('Form data:', this.userData);
// }
//   }

//   // ApiData2() {
//   //   http.get<any>("https://my-json-server.typicode.com/typicode/demo/comments").subscribe(data => {
//   //     this.data = data;
//   //     console.log(this.data);
//   //   });
//   // }

}
