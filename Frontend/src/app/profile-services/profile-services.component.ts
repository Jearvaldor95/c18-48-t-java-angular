import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { APIrestService } from '../service/form-request.service';

@Component({
  selector: 'app-profile-services',
  standalone: true,
  imports: [ CommonModule ],
  templateUrl: './profile-services.component.html',
  styleUrl: './profile-services.component.css'
})
export class ProfileServicesComponent {

  @Input() data: any;

  ngOnInit(): void {
    // console.log('Datos recibidos en ComponenteB:', this.data);
  }

constructor(private apiRestService: APIrestService) {}

  ApiGetData(): void {
    this.apiRestService.getData().subscribe(data => {
      this.data = data;
      // console.log("data recibida en card" + this.data);
    },
      error => {
        console.error('Error al obtener datos:', error);
      }
    );
  }

}
