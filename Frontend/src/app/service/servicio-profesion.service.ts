import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiciosUsuario } from '../interfaces/servicios-usuario';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServicioProfesionService {

  private backendUrl = 'https://domi-production.up.railway.app/api/servicio-profesion'

  constructor(private httpClient: HttpClient) { }

  data: any = {};
  private token: string = '';

  setToken(token: string) {
    this.token = token;
    localStorage.setItem('token', token);
  }

  getToken(): string {
    return this.token || localStorage.getItem('token') || '';
  }

  private getHeaders() {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ´${this.getToken()}´'
    });
  }

  getServiciosProfesionales(): Observable<ServiciosUsuario[]>{
    const headers = this.getHeaders();
    console.log(this.httpClient.get<ServiciosUsuario[]>(`${this.backendUrl}`, { headers }));
    return this.httpClient.get<ServiciosUsuario[]>(`${this.backendUrl}`, { headers });
  }

//   getServicioProfesionalId(id: number){
//     return this.httpClient.get<ServiciosUsuario>(`${this.backendUrl}/${id}`)
//   }
}