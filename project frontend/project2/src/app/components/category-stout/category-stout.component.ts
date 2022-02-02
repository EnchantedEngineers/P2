import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-category-stout',
  templateUrl: './category-stout.component.html',
  styleUrls: ['./category-stout.component.css']
})
export class CategoryStoutComponent implements OnInit {

  // public input:string = "stouts"; 

  public product:any = null; 



  constructor(private ps:ProductsService) { }

  getProducts():void{

    this.ps.getProductsFromApiStouts().subscribe(

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

    this.ps.getSingleProduct(id).subscribe(

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
