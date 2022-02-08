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
 public hiddenMessage: boolean=true;


 constructor(private ps:ProductsService) { }

 getProducts():void{

     this.ps.getPurchasedProducts(this.ps.ownId).subscribe(
     (data:any) => {
       let response:String = data.status

       this.product = data; 
       if(this.product.length == 0) {
         this.hiddenMessage = false;
       }
       console.log(this.product); 
     }, 

     //In case of errors set product object to null
     ()=>{ this.product = null;
       console.log("NO PRODUCT FOUND")
     }

   )

 }


 ngOnInit(): void {
  if (this.ps.ownId == 0){
    window.location.href="http://localhost:4200/login";
  } 
  this.getProducts()
 }


}
