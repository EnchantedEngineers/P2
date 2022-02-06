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
  public id :number=1;


  constructor(private ps:ProductsService) { }

  getProducts():void{

    // this.ps.getProductsFromApiStouts().subscribe(
      this.ps.getProducts(this.id).subscribe(
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

        this.ps.getAllProducts.push(this.product); 

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

}
