import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-category-stout',
  templateUrl: './category-stout.component.html',
  styleUrls: ['./category-stout.component.css']
})
export class CategoryStoutComponent implements OnInit {

  public product:any;
  public id :number=1;

  constructor(private ps: ProductService) { }

  getProducts():void {
    this.ps.getProducts(this.id).subscribe(
      (data:any)=> {
        this.product = data;
        console.log(this.product)
      },
      () => {
        this.product = null;
        console.log("NO PRODUCT FOUND")
      }
    )
  }

  ngOnInit(): void {
   this.getProducts()
  }



}
