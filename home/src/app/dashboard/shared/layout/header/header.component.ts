import { environment } from './../../../../../environments/environment.prod';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DashboardService } from 'src/app/dashboard/dashboard.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router,
    public auth: DashboardService) { }
  ngOnInit(): void {

  }
  rota(){
    this.router.navigate(['/postStock'])
  }
  rota2(){
    this.router.navigate(['/app-header'])
  }

}
