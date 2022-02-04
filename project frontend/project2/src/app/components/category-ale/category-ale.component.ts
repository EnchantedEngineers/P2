import { ArrayType } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-category-ale',
  templateUrl: './category-ale.component.html',
  styleUrls: ['./category-ale.component.css']
})
export class CategoryAleComponent implements OnInit {

  public product:any = null; 
  public id :number=2; 
  public itemnumber :Array<number> = [];
  public quantityAmt :Array<number> = [];
  // public quantityAmt: number = 0; 

  //pass in id for each product

  //then get that product quantity

  //populate the array 

  //ngFor through the value

  constructor(private ps:ProductsService) { }

  getProducts():void{

    // this.ps.getProductsFromApiAle().subscribe(
      this.ps.getProducts(this.id).subscribe(
      (data:any) => {
        let response:String = data.status

        this.product = data; 
        console.log(this.product); 

        // for (let quantity of data){
        //   // let itemnumber2:Array<any> = [0];
        //   let x =quantity.available_quantity
        //     this.itemnumber.push(x)
        //   }


        // console.log(this.itemnumber);
      }, 

      //In case of errors set product object to null
      ()=>{ this.product = null;
        console.log("NO PRODUCT FOUND")
      }

    )

  }

  getQuanity(quantity: number){

    this.quantityAmt = [];

    this.ps.getSingleProduct2(quantity).subscribe(

      (data:any) => {
        let response:String = data.status

        this.product = data; 

        let x =this.product.available_quantity

        for(let y = 1; y <= x; y++){
          this.quantityAmt.push(y)
        }
        
        console.log(this.product); //This works
        // console.log(response);

        console.log(this.quantityAmt);

      }, 

      //In case of errors set product object to null
      ()=>{

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

        console.log(this.product); //This works
        // console.log(response);

        console.log(this.ps.getAllProducts);

      }, 

      //In case of errors set product object to null
      ()=>{

        console.log("NO PRODUCT FOUND")

      }

    )

  }

  ngOnInit(): void {
    this.getProducts(); 
    
  }

  

}
