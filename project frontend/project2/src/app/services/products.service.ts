import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { Login } from '../models/login';
import { Register } from '../models/profile';
import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { Address } from '../models/Address';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http:HttpClient) { }

  getProductsFromApiAle():Observable<Product[]>{

    console.log(this.http.get("https://api.sampleapis.com/beers/ale"));

    return this.http.get("https://api.sampleapis.com/beers/ale/") as Observable<Product[]>
  } //Create two methods to handle each different category

  getProductsFromApiStouts():Observable<Product[]>{

    return this.http.get("https://api.sampleapis.com/beers/stouts/") as Observable<Product[]>
  }




  getProducts(id:number):Observable<Array<Product>>{
    return this.http.get("http://localhost:3000/product/category/" + id) as Observable<Array<Product>>
  }

  login(username:string, password:string):Observable<Login>{
    let user: Observable<Login> = this.http.post<Login>("http://localhost:3000/user", {username, password}) as Observable<Login>;
    return user;
  }

 Register(username:string, password:string, first_name:string, last_name:string, email_address:string, address:Address):Observable<Register>{
  let profile: Observable<Register> = this.http.post<Register>("http://localhost:3000/user/insert", {username, password, first_name, last_name, email_address, address}) as Observable<Register>;
    return profile;
  }

}
