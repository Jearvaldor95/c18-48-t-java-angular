import { Component, Input  } from '@angular/core';
import { RouterLink, RouterOutlet, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [ RouterOutlet, RouterLink, RouterLinkActive,  ],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {
  @Input() data: any;

  ngOnInit(): void {
    console.log('Datos recibidos en ComponenteB:', this.data);
  }
}