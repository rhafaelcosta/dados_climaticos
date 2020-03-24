import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  private senha = 'admin' ;
  private usuario = 'admin';

  constructor(private toastr: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
  }

  login(usuario: string, senha: string) {
    new Promise<boolean>((resolve, reject) => {
      if (this.senha === senha && this.usuario === usuario) {
        resolve();
      } else  {
        reject();
      }
    })
    .then(res => { this.router.navigate(['/dashboard']); })
    .catch(error => { this.toastr.error('Usuário/Senha inválido!'); });
  }

}
