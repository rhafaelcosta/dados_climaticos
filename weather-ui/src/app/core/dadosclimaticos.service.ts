import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import * as moment from 'moment';

import { DadosClimaticos, DadosGrafico } from './model';
import { environment } from './../../environments/environment';

@Injectable()
export class DadosClimaticosService {

  private dadosClimaticosURL: string;

  dadoHistorico: DadosClimaticos[] = [
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
    {cidade: 'Curitiba', data: new Date(), temperatura: 25.68, temperaturaMax: 25.69, temperaturaMin: 12.69, umidade: 49},
  ];

  constructor(private http: HttpClient) {
    this.dadosClimaticosURL = `${environment.apiUrl}/dados/climaticos`;
  }

  public getDadosHistoricos(cidadeId: number, dataInicial: Date, dataFinal: Date): Promise<DadosGrafico[]> {

    let url = `${this.dadosClimaticosURL}/graficos/${cidadeId}`;
    let parans = null;

    if (dataInicial != null) {
      parans = `dataInicial=${moment(dataInicial).format('YYYY-MM-DD')}`;
    }

    if (dataInicial != null) {
      parans += parans != null ? '&' : '';
      parans += `dataFinal=${moment(dataFinal).format('YYYY-MM-DD')}`;
    }

    if (parans != null) {
      url += `?${parans}`;
    }

    return this.http.get<DadosGrafico[]>(url).toPromise();
  }

  public buscarDadosStaticos() {
    return this.dadoHistorico;
  }

}
