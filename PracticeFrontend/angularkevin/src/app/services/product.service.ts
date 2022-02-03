import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../models/login';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  // hiddenCart: boolean

  constructor(private http: HttpClient) { }

  getProducts(id:number):Observable<Array<Product>>{
    return this.http.get("http://localhost:3000/product/category/" + id) as Observable<Array<Product>>
  }

  login(username:string, password:string):Observable<Login>{
    let user: Observable<Login> = this.http.post<Login>("http://localhost:3000/user", {username, password}) as Observable<Login>;
    return user;
  }
}
