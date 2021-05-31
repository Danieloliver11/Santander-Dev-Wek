import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardPageComponent } from './dashboard/dashboard-page/dashboard-page.component';
import { PostStockCardComponent } from './dashboard/post-stock-card/post-stock-card.component';

const routes: Routes = [
  {path:'app-header',component: DashboardPageComponent},
  {path:'postStock',component: PostStockCardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
