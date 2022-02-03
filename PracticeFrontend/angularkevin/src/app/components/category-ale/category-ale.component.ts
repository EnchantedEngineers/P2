import { Component, Input, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-category-ale',
  templateUrl: './category-ale.component.html',
  styleUrls: ['./category-ale.component.css']
})
export class CategoryAleComponent implements OnInit {


  public product:any;
  public id :number=2;

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