import { DashboardService } from './../dashboard.service';
import { Component, OnInit } from '@angular/core';
import Stock from '../shared/models/Stock-model';

@Component({
  selector: 'app-dashboard-page',
  templateUrl: './dashboard-page.component.html',
  styleUrls: ['./dashboard-page.component.css']
})
export class DashboardPageComponent implements OnInit {

  stocks: Stock[] = [];

  constructor(private service: DashboardService) { }

  ngOnInit() {
    this.findAllStock();
  }

  async findAllStock(): Promise<void>{
     // await espera a resposta do serviodr. sopode ser usado com async
     this.stocks = await this.service.getAllStock();
     console.log(this.stocks)
  }

}
