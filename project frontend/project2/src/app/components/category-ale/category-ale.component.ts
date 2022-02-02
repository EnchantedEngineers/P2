import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-category-ale',
  templateUrl: './category-ale.component.html',
  styleUrls: ['./category-ale.component.css']
})
export class CategoryAleComponent implements OnInit {

  // public input:string="ale"; 

  public product:any = null; 
 


  constructor(private ps:ProductsService) { }

  getProducts():void{

    this.ps.getProductsFromApiAle().subscribe(

      (data:any) => {
        let response:String = data.status

        this.product = data; 
        console.log(this.product); 
      }, 

      //In case of errors set product object to null
      ()=>{

      }

    )

  }

  getSingleProduct(id:number):void{

    this.ps.getSingleProduct2(id).subscribe(

      (data:any) => {
        let response:String = data.status

        this.product = data; 
        console.log(this.product); 
      }, 

      //In case of errors set product object to null
      ()=>{

      }

    )

  }

  ngOnInit(): void {
    this.getProducts(); 
  }

  

}
