import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Cidade } from './model';
import { environment } from './../../environments/environment';

@Injectable()
export class CidadeService {

  private cidadeUrl: string;

  constructor(private http: HttpClient) {
    this.cidadeUrl = `${environment.apiUrl}/cidades`;
  }

  // Método respónsavel por consumir api http que busca todas as cidades
  public listar(): Promise<Cidade[]> {
    return this.http.get<Cidade[]>(`${this.cidadeUrl}`).toPromise();
  }

  // Método respónsavel por consumir api http que busca a cidade que está syncronizando os dados
  public buscarCidadeSync(): Promise<Cidade> {
    return this.http.get<Cidade>(`${this.cidadeUrl}/sync`).toPromise();
  }

  // Método respónsavel por consumir api http que alterar a ciddade que está syncronizando os dados
  public AlterarCidadeSync(codigo: number): Promise<any> {
    return this.http.put(`${this.cidadeUrl}/${codigo}/ativo`, null).toPromise();
  }

}
