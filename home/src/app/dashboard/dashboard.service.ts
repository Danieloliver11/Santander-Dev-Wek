import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Stock from './shared/models/Stock-model';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  constructor(private http: HttpClient) { }

  async getAllStock(): Promise<Stock[]>{
    return this.http.get<Stock[]>('http://localhost:8080/bootcamp/stock').toPromise();
  }

  postStock(stock: Stock):Observable <Stock>{
    return this.http.post<Stock>('http://localhost:8080/bootcamp/stock',stock);
  }

  menu(){
    let pagina = false
    if(pagina = true){
      pagina = false
    }
    else if(pagina =false) {
      pagina = true
    }
    return pagina
  }

}


