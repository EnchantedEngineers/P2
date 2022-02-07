import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/app/services/cart.service';
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
     // q =((document.getElementById("quantity") as HTMLInputElement).value);
   // quantity_to_purchase:number=parseInt(this.q);
  order_date: Date=new Date();
        
  constructor(private ps:ProductsService,private cartService:CartService) { }

  ngOnInit(): void {

    this.product = this.ps.getAllProducts; 
   
  }
  remove(id:Number):void{
    //when remove button is clicked I want to remove the item from cart
    //something like so : product.remove(id)
    console.log("removing " + id);
  }
  /*
checout():void{
  for(let  p of this.product)
  {
    let total:number=p.price* this.quantity_to_purchase;
   let orderItem =new OrderItem(0,3,p.id1,this.quantity_to_purchase,total,this.order_date);
    this.cartService.orderItems.push(orderItem)
  }
  console.log('called checkout in cart' + this.product);
  
  this.cartService.placeOrder(this.cartService.orderItems).subscribe(

    //get the data out of the observable that we subscribed to, and put it into a Pokemon object
   (data:any) => {
     let response:String = data.status //gets the status code 

      console.log(response)});

}*/
}
