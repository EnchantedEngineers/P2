import { Component, Input, OnInit, Output } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  subscription: Subscription = new Subscription(); 

  //Cart array
  arrayOfProducts:Array<any> = []; 

  //product object
  public product:any = null; 
 
  constructor(private ps:ProductsService) { }

  ngOnInit(): void {

    //add each product from service to the array
    this.subscription = this.ps.currentMessage.subscribe(serviceMessage => this.product = serviceMessage)


  }

   //function to push new objects into the array
   pushProductsFromStouts():void{

    this.ps.getSingleProduct(this.input).subscribe(
      
      (data:any) => {

        let response:String = data.status

        console.log(response);       

        this.product = data.body; 
        console.log(this.product);

        this.ps.product = data.body;  //maybe we don't need to send this back to the service
      }
  
    )
  
    }

}
