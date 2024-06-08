import { Component } from '@angular/core';
import { RouterLink, RouterOutlet, RouterLinkActive } from '@angular/router';
import { APIrestService } from '../service/form-request.service';
import { CommonModule } from '@angular/common';

// pages components
import { NavBarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { CardComponent } from '../card/card.component';

@Component({
  selector: 'app-professionals',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, NavBarComponent, FooterComponent, CardComponent, CommonModule ],
  templateUrl: './professionals.component.html',
  styleUrl: './professionals.component.css'
})
export class ProfessionalsComponent {
  data: any[] = [];

  constructor(private APIrestService: APIrestService) { }

  ngOnInit(): void {
    this.showData();
  }

  showData() {
    this.APIrestService.getData().subscribe(data => {
      this.data = data;
      // console.log("salida professionals" + data);
    });
  }
}
