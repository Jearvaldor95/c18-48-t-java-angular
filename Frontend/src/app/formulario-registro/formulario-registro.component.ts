//  Basics
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { RouterOutlet } from '@angular/router';
import { RouterLinkActive } from '@angular/router';
import { FormRequestService } from "../service/form-request.service";
import { FormControl, FormGroup, FormsModule } from "@angular/forms";
import { ReactiveFormsModule } from '@angular/forms';

// pages components
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { FooterComponent } from '../footer/footer.component';
import { subscribe } from 'node:diagnostics_channel';

@Component({
  selector: 'app-formulario-registro',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive, NavBarComponent, FooterComponent, FormsModule, ReactiveFormsModule],
  templateUrl: './formulario-registro.component.html',
  styleUrl: './formulario-registro.component.css'
})

export class FormularioRegistroComponent {

  data: any[] = [];

  userData = {
    name: '',
    lastname: '',
    tel: '',
    email: '',
    address: '',
    user: '',
    pass: '',
  };

  constructor(public FormRequestService: FormRequestService) { }

ApiData() {
  this.FormRequestService.getData().subscribe(data => {
    this.data = data;
    console.log(this.data);
  },
    error => {
      console.error('Error al obtener datos:', error);
    }
  )
}

submitForm(form: any): void {
  if(form.valid) {
  console.log('Form data:', this.userData);
}
  }

  // ApiData2() {
  //   http.get<any>("https://my-json-server.typicode.com/typicode/demo/comments").subscribe(data => {
  //     this.data = data;
  //     console.log(this.data);
  //   });
  // }

}
