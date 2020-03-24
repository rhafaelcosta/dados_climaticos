import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Dados Climáticos';

  constructor(private router: Router) { }

  exibindoNavbar() {
    return this.router.url !== '/login';
  }

}
