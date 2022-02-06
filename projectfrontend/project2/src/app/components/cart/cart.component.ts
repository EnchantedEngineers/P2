import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public product:Array<Product> = []; 

  constructor(private ps:ProductsService) { }

  ngOnInit(): void {

    this.product = this.ps.getAllProducts; 
   
  }

}
