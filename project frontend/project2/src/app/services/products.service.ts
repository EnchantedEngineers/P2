import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

 singleProduct:Array<Product>=[];


  constructor(private http:HttpClient) { }

  getProductsFromApiAle():Observable<Product[]>{

    console.log(this.http.get("https://api.sampleapis.com/beers/ale"));

    return this.http.get("https://api.sampleapis.com/beers/ale/") as Observable<Product[]>
  } //Create two methods to handle each different category

  getProductsFromApiStouts():Observable<Product[]>{

    return this.http.get("https://api.sampleapis.com/beers/stouts/") as Observable<Product[]>
  }

  getSingleProduct(id:number):Observable<Product>{

    return this.http.get("https://api.sampleapis.com/beers/stouts/" + id) as Observable<Product>;
  }

  getSingleProduct2(id:number):Observable<Product>{

    return this.http.get("https://api.sampleapis.com/beers/ale/" + id) as Observable<Product>;
  }


  addToCart(product:Object){

    //add product to an array that we'll on the cart page

  }
}
