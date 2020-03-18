import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/api-client/product.service';
import { ProductModel } from 'src/app/api-client/models/product.model';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'product-summary',
  templateUrl: './product-summary.component.html',
  styleUrls: ['./product-summary.component.scss']
})
export class ProductSummaryComponent implements OnInit {

  constructor(
    private service: ProductService
  ) { }

  ngOnInit(): void {
    this.service.getProductGroups();
  }
}
