import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import { UserProductsModule } from './user-products/user-products.module';
import { ApiClientModule } from './api-client/api-client.module';
import { StatsModule } from './stats/stats.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CommonModule,
    UserProductsModule,
    StatsModule,
    ApiClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
