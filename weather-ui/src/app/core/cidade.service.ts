import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Cidade } from './model';
import { environment } from './../../environments/environment';

@Injectable()
export class CidadeService {

  private cidadeUrl: string;

  constructor(private http: HttpClient) {
    this.cidadeUrl = `${environment.apiUrl}/cidades`;
  }

  public listar(): Promise<Cidade[]> {
    return this.http.get<Cidade[]>(`${this.cidadeUrl}`).toPromise();
  }

  public buscarCidadeSync(): Promise<Cidade> {
    return this.http.get<Cidade>(`${this.cidadeUrl}/sync`).toPromise();
  }

  public AlterarCidadeSync(codigo: number): Promise<any> {
    return this.http.put(`${this.cidadeUrl}/${codigo}/ativo`, null).toPromise();
  }

}
