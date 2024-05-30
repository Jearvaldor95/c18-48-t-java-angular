import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormularioRegistroComponent } from "./formulario-registro/formulario-registro.component";
import { NavBarComponent } from "./nav-bar/nav-bar.component";
import { FooterComponent } from "./footer/footer.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, FormularioRegistroComponent, NavBarComponent, FooterComponent]
})
export class AppComponent {
  title = 'domi';
}
