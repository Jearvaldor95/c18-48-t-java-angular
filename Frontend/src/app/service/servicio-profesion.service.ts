import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiciosUsuario } from '../interfaces/servicios-usuario';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServicioProfesionService {

  private backendUrl = 'http://localhost:8095/api/servicio-profesion'

  constructor(private httpClient: HttpClient) { }

  data: any = {};

  setData(key: string, value: any) {
    this.data[key] = value;
  }

  getData(key: string): any {
    return this.data[key];
  }


  getServiciosProfesionales(): Observable<ServiciosUsuario[]>{
    return this.httpClient.get<ServiciosUsuario[]>(`${this.backendUrl}`);
  }

  getServicioProfesionalId(id: number){
    return this.httpClient.get<ServiciosUsuario>(`${this.backendUrl}/${id}`)
  }
}
