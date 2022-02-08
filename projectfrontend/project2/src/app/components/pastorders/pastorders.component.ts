import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-pastorders',
  templateUrl: './pastorders.component.html',
  styleUrls: ['./pastorders.component.css']
})
export class PastordersComponent implements OnInit {

 // public input:string = "stouts"; 

 public product:any = null; 
 public id :number=1;
 


 constructor(private ps:ProductsService) { }

 getProducts():void{

     this.ps.getPurchasedProducts(this.ps.ownId).subscribe(
     (data:any) => {
       let response:String = data.status

       this.product = data; 
       console.log(this.product); 
     }, 

     //In case of errors set product object to null
     ()=>{ this.product = null;
       console.log("NO PRODUCT FOUND")
     }

   )

 }

 getSingleProduct(product_id:any):void{

   this.ps.getSingleProduct2(product_id).subscribe(

     (data:any) => {
       let response:String = data.status

       this.product = data; 
       let valueid = this.product.id1;
       let valuequantity = this.product.available_quantity;  this.product.price = (this.product.price*0.9).toFixed(2);
       let index = this.ps.getAllProducts.findIndex(object => object.id1 === valueid);
       if (index === -1){
       if (valuequantity != 0){
       this.ps.getAllProducts.push(this.product); 
       }
     }

       // this.getAllProducts.push(this.product); 

       console.log(this.product); //This works
       // console.log(response);


     }, 

     //In case of errors set product object to null
     ()=>{

       console.log("NO PRODUCT FOUND")

     }

   )

 }

 ngOnInit(): void { this.getProducts()
 }
 url: string = "../assets/budlight.png";
changeImage(event: any){
 this.url = event.target.src;
 console.log();
}

}
