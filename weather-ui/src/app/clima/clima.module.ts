import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ChartsModule } from 'ng2-charts';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

import { DadosClimaticosComponent } from './dadosclimaticos/dadosclimaticos.component';

@NgModule({
  declarations: [ DadosClimaticosComponent ],
  exports: [ DadosClimaticosComponent ],
  imports: [
    FormsModule,
    CommonModule,
    ChartsModule,
    ReactiveFormsModule,
    BsDatepickerModule.forRoot()
  ]
})
export class ClimaModule { }
