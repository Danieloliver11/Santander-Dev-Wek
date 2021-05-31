import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardPageComponent } from './dashboard-page/dashboard-page.component';
import { StockCardComponent } from './stock-card/stock-card.component';
import{HttpClientModule} from '@angular/common/http';
import { PostStockCardComponent } from './post-stock-card/post-stock-card.component'
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    DashboardPageComponent,
    StockCardComponent,
    PostStockCardComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  exports:[           // export nosso novo modulo para app.component.html e todos outros modulos se tiver.
    DashboardPageComponent,
  ]
})


export class DashboardModule { }
