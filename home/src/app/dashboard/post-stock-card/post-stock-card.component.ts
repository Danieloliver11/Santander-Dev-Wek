import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { DashboardService } from '../dashboard.service';
import Stock from '../shared/models/Stock-model';

@Component({
  selector: 'app-post-stock-card',
  templateUrl: './post-stock-card.component.html',
  styleUrls: ['./post-stock-card.component.css']
})
export class PostStockCardComponent implements OnInit {
  stock: Stock = new Stock();
  constructor(private service: DashboardService,
    private router: Router) { }

  ngOnInit() {
  }

   postarStok(){
    this.service.postStock(this.stock).subscribe((resp: Stock)=>{
      this.stock = resp
      alert("Cadastro realizado com sucesso!")
      this.router.navigate(['/app-header'])
    })
  }



}
