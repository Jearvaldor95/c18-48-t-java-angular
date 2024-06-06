import { Component } from '@angular/core';
import { RouterLink, RouterOutlet, RouterLinkActive } from '@angular/router';
import { APIrestService } from '../service/form-request.service';

// pages components
import { NavBarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-professionals',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, NavBarComponent, FooterComponent],
  templateUrl: './professionals.component.html',
  styleUrl: './professionals.component.css'
})
export class ProfessionalsComponent {

  ngOnInit(): void {

  }

  data: any[] = [];

  constructor(private APIrestService: APIrestService) { }

  storeData() {
    this.APIrestService.getData().subscribe(data => {
      this.data = data;
      console.log(this.data);
    })
  }
}
