import { Component } from '@angular/core';
import { RouterLink, RouterOutlet, RouterLinkActive } from '@angular/router';
import { APIrestService } from '../service/form-request.service';
import { CommonModule } from '@angular/common';

// pages components
import { NavBarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { ProfileServicesComponent } from '../profile-services/profile-services.component';
import { Location } from '@angular/common';
import { ServicioProfesionService } from '../service/servicio-profesion.service';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SolicitudService } from '../service/solicitud.service';
import { Solicitud } from '../interfaces/solicitud';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, NavBarComponent, FooterComponent, ProfileServicesComponent, CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})

export class ProfileComponent {

  data: any;
  
  
  myForm!: FormGroup;
  solicitud!: Solicitud;

  constructor(private APIrestService: APIrestService,private fb:FormBuilder, private servicioProfesion: ServicioProfesionService, private solicitudService: SolicitudService, private location: Location ) { 
    
  }
  ngOnInit(): void {
    this.showData();
  
    // this.data = this.servicioProfesion.getData('perfil');
    // console.log(this.data);
    // this.formulario();
  }


  // formulario(){
  //   this.myForm = this.fb.group({
  //     idSolicitud: [this.data?.idSolicitud || ''],
  //     idServicioProfesion: [this.data?.idServicioProfesion || ''],
  //     idUsuario: [this.data?.idUsuario || ''],
  //     mensaje: [this.data?.mensaje || ''],
  //     estado: [this.data?.estado || ''],
  //     resena: [this.data?.resena || ''],
  //     estrellas: [this.data?.estrellas || '']
  //   });
  // }

  showData() {
    this.APIrestService.getData().subscribe(data => {
      this.data = data;
      console.log(this.data);
    })
  }

  goBack() {
    this.location.back();}

  // enviarSolicitud(form: FormGroup){
  //   if (this.myForm.valid) {
  //     if (form.value.id && form.value.id !== 0) {
  //       return;
  //     }
  //     this.solicitudService.enviarSolicitud(form.value)
  //       .subscribe(data => {
  //         //this.messageService.add({ severity: 'success', summary: 'Success Message', detail: 'Solicitud enviada! '});
  //         console.log(data);
  //       }
  //       )
  //   }
  //   else {
  //     //this.messageService.add({ severity: 'error', summary: 'Error Message', detail: 'Formulario invalido' });
  //   }
  // }
  

}
