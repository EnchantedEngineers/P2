import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public product:Array<Product> = [];
  public eachPrice: number = 0;
  public totalPrice: number = 0;
  public hiddenThanks: boolean = true;
  // order_date:Date = new Date();
  
  constructor(private ps:ProductsService) { }

  ngOnInit(): void {

    if (this.ps.ownId == 0){
      window.location.href="http://localhost:4200/login";
    }
    this.product = this.ps.getAllProducts;
    
    for (let n of this.product) {
      n.eachprice = n.qnt * n.price;
      n.ownId = this.ps.ownId;
    }
    this.getTotalPrice();
    
  
  }

  getTotalPrice():void{
    let sum:number = this.product.map(a => a.eachprice).reduce(function(a,b){
      return a + b;
    });
    
    this.totalPrice = sum;
   Number(this.totalPrice).toFixed(2);
  }

  removeItem(product_id:number):void{
    
    this.ps.getSingleProduct2(product_id).subscribe(

      (data:any) => {

        let response:String = data.status
        this.product.forEach((value,index)=>{
        if(value.id1==product_id) this.product.splice(index,1);
    });
      
        if (this.product.length==0){
          this.totalPrice = 0;
        }
        this.getTotalPrice();
        console.log(this.product); 
        console.log(this.ps.getAllProducts);

      }, 
      ()=>{

        console.log("NO PRODUCT FOUND")

      }

    )

  }

  inc(prod:any):any{
    if (prod.qnt<prod.available_quantity){
      prod.qnt = prod.qnt + 1;
      prod.eachprice = prod.qnt*prod.price
      this.getTotalPrice();
      console.log(this.product)
    } else if (prod.qnt = prod.available_quantity){
      prod.qnt = prod.qnt;
      this.totalPrice = this.totalPrice;
    } 
  }

  dec(prod:any):void{
    
    if (prod.qnt > 1){
      prod.qnt = prod.qnt - 1;
      prod.eachprice = prod.qnt*prod.price
      this.getTotalPrice();
      console.log(this.product)
    } else if (prod.qnt = 1) {
      prod.qnt = prod.qnt;
      this.totalPrice = this.totalPrice;
    }
  }

  checkingOut():void{
   
 
    this.ps.updateProduct(this.product).subscribe(

      (data:any) => {
        let response:String = data.status
    

      }, 
      ()=>{

        console.log("NO PRODUCT FOUND")
        this.ps.getAllProducts.splice(0,this.product.length)
        this.totalPrice=0;
       
      }

    )
   
  }
}
