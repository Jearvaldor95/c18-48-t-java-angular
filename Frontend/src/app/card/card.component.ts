import { Component, Input } from '@angular/core';
import { RouterLink, RouterOutlet, RouterLinkActive, Router } from '@angular/router';
import { APIrestService } from '../service/form-request.service';
import { CommonModule } from '@angular/common';
import { ServicioProfesionService } from '../service/servicio-profesion.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, CommonModule ],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {
  
  @Input() data: any;

  ngOnInit(): void {
    // console.log('Datos recibidos en ComponenteB:', this.data);
  }

  myForm!: FormGroup;
constructor(private router: Router, private servicioProfesion: ServicioProfesionService) {}

 /* ApiGetData(): void {
    this.apiRestService.getData().subscribe(data => {
      this.data = data;
      // console.log("data recibida en card" + this.data);
    },
      error => {
        console.error('Error al obtener datos:', error);
      }
    );
  }*/

  
  // verProfesional(id: number) {
  //   this.servicioProfesion.getServicioProfesionalId(id).subscribe(data => {
  //     this.servicioProfesion.setData('perfil', data);
  //     this.router.navigate(['/profile']);
  //   })
  // }

}