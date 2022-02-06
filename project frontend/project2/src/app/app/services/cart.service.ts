import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderItem } from 'src/app/models/OrderItem';





@Injectable({
  providedIn: 'root'
})
export class CartService {

  public orderItems :Array<OrderItem> = [];

  //constructor(private http:HttpClient) { }

  addToCart(productItem:OrderItem):void{
      this.orderItems.push(productItem);
    
}
  
}

