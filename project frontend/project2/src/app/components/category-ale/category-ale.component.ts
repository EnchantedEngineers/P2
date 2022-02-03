import { Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-category-ale',
  templateUrl: './category-ale.component.html',
  styleUrls: ['./category-ale.component.css']
})
export class CategoryAleComponent implements OnInit {

  //product object to be added to an array of objects that we want to display on cart page
  public product:any = null; 

  subscription: Subscription = new Subscription();

  constructor(private ps:ProductsService) { }

  getProducts():void{

    this.ps.getProductsFromApiAle().subscribe(

      (data:any) => {
        let response:String = data.status

        this.product = data; 
        console.log(this.product); 

      }, 

      //In case of errors set product object to null
      ()=>{

      }

    )

  }

  
    getSingleProduct(id:number):void{

    this.ps.getSingleProduct2(id).subscribe(

      (data:any) => {
        let response:String = data.status

        this.product = data; 

        console.log(this.product); //This works


      }, 

      //In case of errors set product object to null
      ()=>{

      }

    )

  }

  

  ngOnInit(): void {
    this.getProducts(); 
  }

  

}
