import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderItem } from 'src/app/models/OrderItem';





@Injectable({
  providedIn: 'root'
})
export class CartService {
  

  public orderItems :Array<OrderItem> = [];

  constructor(private http:HttpClient) { }

  placeOrder(order:Array<OrderItem>):Observable<Array<OrderItem>>{

    let  orders: Observable<Array<OrderItem>> = this.http.post(" ",order) as Observable<Array<OrderItem>> ;
    return orders;
  }

  addToCart(productItem:OrderItem):void{
      this.orderItems.push(productItem);
    
}
  
}

