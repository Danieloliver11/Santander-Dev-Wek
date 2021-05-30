import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Stock from './shared/models/Stock-model';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient) { }

  async getAllStock(): Promise<Stock[]>{
    const url = 'http://localhost:8080/bootcamp/stock';
    return this.http.get<Stock[]>(url).toPromise();
  }
}
