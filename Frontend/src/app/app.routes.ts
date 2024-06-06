import { Routes } from '@angular/router';
import { RegistroComponent } from "./registro/registro.component";
import { HomeComponent } from "./home/home.component";
import { FooterComponent } from './footer/footer.component';
import { NavBarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { LegalComponent } from './legal/legal.component';
import { PageNotFoundComponent } from './pageNotFound/pageNotFound.component';
import { ProfessionalsComponent } from './professionals/professionals.component';
import { ProfileComponent } from './profile/profile.component';
import { AccountComponent } from './account/account.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'navbar', component: NavBarComponent },
    { path: 'footer', component: FooterComponent },
    { path: 'registro', component: RegistroComponent },
    { path: 'login', component: LoginComponent },
    { path: 'legal', component: LegalComponent },
    { path: 'professionals', component: ProfessionalsComponent },
    { path: 'profile', component: ProfileComponent },
    { path: 'account', component: AccountComponent },
    // siempre ultimo
    { path: '**', component: PageNotFoundComponent },
];
