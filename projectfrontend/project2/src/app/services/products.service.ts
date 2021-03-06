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

  getAllProducts :Array<Product> = [];
  ownId : number =0;
  fn : any;
  ln : any;
  ownuser : any;
  ownpass : any;
  ownemail : any;

  addressId: any;
  ownAddress: any;
  ownCity: any;
  ownCountry: any;
  ownCode: any;
  ownState: any;

  constructor(private http:HttpClient) { }

  updateAddress(address:Address):Observable<Address>{
    return this.http.post("http://localhost:3000/address", address) as Observable<Address>;

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

  getSingleProduct2(id:number):Observable<Product>{

    return this.http.get("http://localhost:3000/product/" + id) as Observable<Product>;
  }

  updateProduct(getAllProducts:any):Observable<Array<Product>>{
    return this.http.post("http://localhost:3000/product", getAllProducts) as Observable<Array<Product>>;

  }

  getPurchasedProducts(id:number):Observable<Array<Product>>{
    return this.http.get("http://localhost:3000/order/" + id) as Observable<Array<Product>>
  }


}
