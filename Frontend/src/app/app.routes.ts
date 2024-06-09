import { Routes } from '@angular/router';
import { FormularioRegistroComponent } from "./formulario-registro/formulario-registro.component";
import { HomeComponent } from "./home/home.component";
import { FooterComponent } from './footer/footer.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';

export const routes: Routes = [
    { path: 'nav-bar', component: NavBarComponent },
    { path: 'footer', component: FooterComponent },
    { path: '', component: HomeComponent },
    { path: 'formulario-registro', component: FormularioRegistroComponent },
];
