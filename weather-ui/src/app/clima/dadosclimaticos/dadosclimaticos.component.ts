import { Component, OnInit } from '@angular/core';

defineLocale('pt-br', ptBrLocale);
import { ToastrService } from 'ngx-toastr';
import { ChartOptions, ChartDataSets } from 'chart.js';
import { BsLocaleService, defineLocale, ptBrLocale } from 'ngx-bootstrap';

import { DadosClimaticos } from './../../core/model';
import { Cidade, DadosGrafico } from '../../core/model';
import { CidadeService } from './../../core/cidade.service';
import { DadosClimaticosService } from './../../core/dadosclimaticos.service';

@Component({
  selector: 'app-dadosclimaticos',
  templateUrl: './dadosclimaticos.component.html',
  styleUrls: ['./dadosclimaticos.component.css']
})
export class DadosClimaticosComponent implements OnInit {

  locale = 'pt-br';
  selectedCidade: Cidade;
  selectedValue = null;
  dataInicial = new Date();
  dataFinal = new Date();
  cidades: Cidade[] = [] ;
  dadoHistorico: DadosClimaticos[] = [];

  // Chart Parameters
  showCharts = true;
  chartLegend = true;
  chartLabels: string[] = [];
  chartOptions: ChartOptions = { responsive: true };
  lineChartData = [{ data: [], fill: false, label: ''}];
  barChartData: ChartDataSets[] = [ { data: [], label: '', type: 'line' } ];

  tempMax: number[];
  tempMin: number[];
  temp: number[];
  umidade: number[];

  constructor(private localeService: BsLocaleService,
              private cidadeService: CidadeService,
              private dadosClimaticosService: DadosClimaticosService,
              private toastr: ToastrService) {
    this.localeService.use(this.locale);
    this.cidadeService.buscarCidadeSync()
                      .then(cidade => {
                        this.selectedCidade = cidade;
                        this.selectedValue = cidade.id;
                        this.buscarDadosClimaticos(this.selectedValue, null, null);
                      })
                      .catch(erro => {
                        this.toastr.error('Não foi possível buscar os dados do servidor!');
                      });
  }

  ngOnInit(): void {
    this.cidadeService.listar().then(cidades => this.cidades = cidades);
    this.dadoHistorico = this.dadosClimaticosService.buscarDadosStaticos();
  }

  pesquisar() {
    this.buscarDadosClimaticos(this.selectedValue, this.dataInicial, this.dataFinal, true);
  }

  // Método respónsavel por alterar a cidade que está syncronizando os dados
  SyncCidade() {
    this.cidadeService.AlterarCidadeSync(this.selectedValue)
                      .then(cidade => {
                        this.selectedCidade =  new Cidade(cidade.id, cidade.nome);
                        this.toastr.success('Syncronização realizada com sucesso!');
                      })
                      .catch(erro => {
                        this.toastr.error('Ocorreu um erro ao alterar a syncronização da cidade!');
                      });
  }

  // Método respónsavel por buscar os dados climaticos
  private buscarDadosClimaticos(cidadeId: number, dataInicial: Date, dataFinal: Date, showMessage: boolean = false) {
    this.dadosClimaticosService.getDadosHistoricos(cidadeId, dataInicial, dataFinal)
                               .then(dados => {
                                 this.gerarGrafico(dados);
                                 if (showMessage && dados != null) {
                                  this.toastr.success('Busca realizada com sucesso');
                                 }
                                })
                                .catch (erro => {
                                  this.toastr.error('Não foi possível localizar os dados climáticos');
                                });
  }

  // Método respónsavel por gerar os gráficos
  private gerarGrafico(dados: DadosGrafico[]) {
    this.temp = [];
    this.tempMax = [];
    this.tempMin = [];
    this.umidade = [];
    this.chartLabels = [];

    dados.map( (dado: DadosGrafico) => {
      this.tempMax.push(dado.temperaturaMaxima);
      this.tempMin.push(dado.temperaturaMinima);
      this.temp.push(dado.temperatura);
      this.umidade.push(dado.umidade);
      this.chartLabels.push(dado.data);
    });

    this.lineChartData = [
      {data: this.tempMax, fill: false, label: 'Temperatura Máxima'},
      {data: this.tempMin, fill: false, label: 'Temperatura Minima'}
    ];

    this.barChartData = [
      { data: this.temp, fill: false, label: 'Temperatura', type: 'line' },
      { data: this.umidade, label: 'Umidade', }
    ];

    this.showCharts = (this.chartLabels == null || this.chartLabels.length < 1) ? true : false;
  }

}
