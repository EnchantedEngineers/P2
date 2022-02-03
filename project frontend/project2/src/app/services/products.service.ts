import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})

export class ProductsService {

  

 public messageSource = new BehaviorSubject("Product is not here yet");

 currentMessage = this.messageSource.asObservable(); 

  //product object
  public product:any = null; 

//change message function
changeMessage(newMessage: string){

  this.messageSource.next(newMessage); 
}




  constructor(private http:HttpClient) { }

  getProductsFromApiAle():Observable<Product[]>{

    console.log(this.http.get("https://api.sampleapis.com/beers/ale"));

    return this.http.get("https://api.sampleapis.com/beers/ale/") as Observable<Product[]>
  } //Create two methods to handle each different category

  getProductsFromApiStouts():Observable<Product[]>{

    return this.http.get("https://api.sampleapis.com/beers/stouts/") as Observable<Product[]>
  }

  //These functions will change default String
  getSingleProduct(id:number):Observable<Product>{

    return this.http.get("https://api.sampleapis.com/beers/stouts/" + id) as Observable<Product>;
  }

  getSingleProduct2(id:number):Observable<Product>{

    return this.http.get("https://api.sampleapis.com/beers/ale/" + id) as Observable<Product>;
  }
  
}
