import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { ProductGroupModel } from './models/product-group.model';
import { ProductModel } from './models/product.model';
import { ProductDetailModel } from './models/product-detail.model';

const savings: ProductModel[] = [{
  product_name: 'Kids Savings',
  balance: '2000.00',
  id: '1'
}, {
  product_name: 'Orange',
  balance: '500.00',
  id: '2'
}];

const payments: ProductModel[] = [{
  product_name: 'Quarterly payments',
  balance: '800.00',
  id: '3'
}, {
  product_name: 'Payments Accounts',
  balance: '600.00',
  id: '4'
}];

const mortgage: ProductModel[] = [{
  product_name: 'Quarterly payments',
  balance: '800.00',
  id: '5'
}];

const groups: ProductGroupModel[] = [{
  group_name: 'Savings',
  id: '1'
}, {
  group_name: 'Payments',
  id: '2'
}, {
  group_name: 'Mortgage',
  id: '3'
}];

const currentProduct: ProductDetailModel = {
  name: 'Quarterly Payments',
  balance: '800.00',
  interest_rate: '2%',
  account: 'INGB NL42 1212 41234',
  earnings: '4.00'
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private groupsSubject = new BehaviorSubject(groups);
  productGroups$ = this.groupsSubject.asObservable();

  private savingsSubject = new BehaviorSubject(savings);
  savingsProducts$ = this.savingsSubject.asObservable();

  private paymentsSubject = new BehaviorSubject(payments);
  paymentsProducts$ = this.paymentsSubject.asObservable();

  private mortgagesSubject = new BehaviorSubject(mortgage);
  mortgagesProducts$ = this.mortgagesSubject.asObservable();

  private productDetailSubject = new BehaviorSubject(currentProduct);
  currentProduct$ = this.productDetailSubject.asObservable();


  constructor(
    private httpClient: HttpClient
  ) { }

  getProductGroups(): void {
    this.productGroups$ = this.httpClient.get<ProductGroupModel[]>(`/productGroups`);
  }

  getProductsByGroupId(groupId: string): Observable<ProductGroupModel[]> {
    return this.httpClient.get<ProductGroupModel[]>(`products/${groupId}`)
  }

  getProductDetails(id: string): void {
    this.currentProduct$ = this.httpClient.get<ProductDetailModel>(`productDetails/${id}`);
  }

}
