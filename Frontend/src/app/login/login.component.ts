import { Component, OnInit  } from '@angular/core';
import { RouterLink, RouterOutlet, RouterLinkActive, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// pages components
import { NavBarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ NavBarComponent, FooterComponent,RouterOutlet, RouterLink, RouterLinkActive, ReactiveFormsModule ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  private backendUrl = 'http://localhost:8095/'
 
  loginForm: FormGroup = new FormGroup({}); 
  errorMessage: string = '';

  constructor(private fb: FormBuilder,private loginService: LoginService, private router: Router, private httpClient: HttpClient){}

  data: any = {};
  private token: string = '';

    ngOnInit(): void {

    }

onSubmit(){
  console.log(this.loginForm.value);
}

// login() {
//   this.loginService.loginServices(loginForm.value).subscribe(data => {
//     this.data = data;
//     console.log(this.data);
//   });;
//   return this.httpClient.post<any>(`${this.backendUrl}/auth/login`, body);

// }

  // login(loginForm: FormGroup){
  //     this.loginService.login(loginForm.value)
  //       .subscribe( {
  //         next: () => {
  //           // Navegar a otra ruta después de un inicio de sesión exitoso
  //           this.router.navigate(['/professionals']);
  //         },
  //         error: () => {
  //           // Manejar errores de inicio de sesión
  //           this.errorMessage = 'Credenciales invalidas';
  //         }
          
  //       }
  //     );
  // }

}
