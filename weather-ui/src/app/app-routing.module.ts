import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginFormComponent } from './seguranca/login-form/login-form.component';
import { PaginaNaoEncontradaComponent } from './core/pagina-nao-encontrada.component';
import { DadosClimaticosComponent } from './clima/dadosclimaticos/dadosclimaticos.component';

// Cadastro de rotas de navegação
const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginFormComponent },
  { path: 'dashboard', component: DadosClimaticosComponent },
  { path: 'pagina-nao-encontrada', component: PaginaNaoEncontradaComponent },
  { path: '**', redirectTo: 'pagina-nao-encontrada' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
