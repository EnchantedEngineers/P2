import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { Login } from '../models/login';
@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http:HttpClient) { }

  getProducts(id:number):Observable<Array<Product>>{
    return this.http.get("http://localhost:3000/product/category/" + id) as Observable<Array<Product>>
  }

  login(username:string, password:string):Observable<Login>{
    let user: Observable<Login> = this.http.post<Login>("http://localhost:3000/user", {username, password}) as Observable<Login>;
    return user;
  }

  getSingleProduct2(id:number):Observable<Product>{

    return this.http.get("http://localhost:3000/product/" + id) as Observable<Product>;
  }

}
