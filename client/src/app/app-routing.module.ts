import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductSummaryComponent } from './user-products/product-summary/product-summary.component';
import { ProductDetailComponent } from './user-products/product-detail/product-detail.component';


const routes: Routes = [
  {path: 'account-overview', component: ProductSummaryComponent},
  {path: 'detail/:id', component: ProductDetailComponent},

  {path: '', redirectTo: '/account-overview', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
