import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductGroupComponent } from './product-group/product-group.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductSummaryComponent } from './product-summary/product-summary.component';
import { RouterModule } from '@angular/router';
import { MatTableModule } from '@angular/material/table';




@NgModule({
  declarations: [ProductGroupComponent, ProductDetailComponent, ProductSummaryComponent],
  imports: [
    CommonModule,
    RouterModule,
    MatTableModule
  ]
})
export class UserProductsModule { }
