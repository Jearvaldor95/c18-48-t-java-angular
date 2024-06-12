import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../interfaces/login';
import { Observable, tap } from 'rxjs';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginForm: FormGroup = new FormGroup({});

  private backendUrl = 'http://localhost:8095/auth/login'

  constructor(private httpClient: HttpClient,private fb: FormBuilder) { }

  loginServices(login: Login): Observable<any> {
    //const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const body = this.loginForm = this.fb.group({
      email: [''],
      password: ['']
    });;
    return this.httpClient.post<any>(this.backendUrl, body).pipe(
      tap(response => {
        if (response && response.token) {
          localStorage.setItem('authToken', response.token);
          console.log(response.token);
        }
      })
    );
  }

  logout(): void {
    localStorage.removeItem('authToken');
  }

  getToken(): string | null {
    return localStorage.getItem('authToken');
  }
}

