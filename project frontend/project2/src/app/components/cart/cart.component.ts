import { Component, OnInit } from '@angular/core';
import { OrderItem } from 'src/app/models/OrderItem';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';
//import {CartService} from 'src/app/services/cart.service';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public product:Array<Product> = []; 
public  quantity_to_purchase:string='quantity';
  constructor(private ps:ProductsService) { }

  ngOnInit(): void {

    this.product = this.ps.getAllProducts; 
   
  }
  remove(id:Number):void{
    //when remove button is clicked I want to remove the item from cart
    //something like so : product.remove(id)
    console.log("removing " + id);
  }
checout():void{
  console.log('called checkout in cart' + this.product);
  
  //this.ps.placeOrder(this.product).subscribe(

    //get the data out of the observable that we subscribed to, and put it into a Pokemon object
  //  (data:any) => {
     // let response:String = data.status //gets the status code 

     // console.log(response)})

}
}
