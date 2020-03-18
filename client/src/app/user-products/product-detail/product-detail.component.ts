import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/api-client/product.service';
import { switchMap, map } from 'rxjs/operators'

@Component({
  selector: 'product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private service: ProductService
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      map( params => this.service.getProductDetails(params.get('id')))
    );
  }

}
