import { registerLocaleData } from '@angular/common';
import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { SharedModule } from './dashboard/shared/shared.module';
import localePt from '@angular/common/locales/pt'; // importa a mao

registerLocaleData(localePt); //

@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [ // sempre temos que importar nossos modulos novos aqui, para a rota funcionar. global
    BrowserModule,
    AppRoutingModule,
    DashboardModule,
    SharedModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'pt-BR'} //
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
