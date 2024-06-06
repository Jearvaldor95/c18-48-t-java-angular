import { Component } from '@angular/core';
import { RouterLink, RouterOutlet, RouterLinkActive } from '@angular/router';

// pages components
import { NavBarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-pageNotFound',
  standalone: true,
  imports: [ NavBarComponent, FooterComponent,RouterOutlet, RouterLink, RouterLinkActive ],
  templateUrl: './pageNotFound.component.html',
  styleUrl: './pageNotFound.component.css'
})
export class PageNotFoundComponent {

}
