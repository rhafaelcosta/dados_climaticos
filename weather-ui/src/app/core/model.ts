export class DadosClimaticos {
  cidade: string;
  data: Date;
  temperatura: number;
  temperaturaMax: number;
  temperaturaMin: number;
  umidade: number;
}

export class DadosGrafico {
  data: string;
  temperatura: number;
  temperaturaMaxima: number;
  temperaturaMinima: number;
  umidade: number;
  pressao: number;
}

export class Cidade {
  id: number;
  nome: string;

  constructor(id: number, nome: string) {
    this.id = id;
    this.nome = nome;
  }

}
