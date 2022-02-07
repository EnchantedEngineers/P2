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
  // public itemnumber:Array<any> = [];
  // public itemnumber2:Array<any> = [];
  // public quantityAmt :Array<number> = [];

  


  constructor(private ps:ProductsService) { }

  getProducts():void{
      // this.quantityAmt = [];
      this.ps.getProducts(this.id).subscribe(
      (data:any) => {
        let response:String = data.status
        
        this.product = data; 
        // let z =this.product.available_quantity
        // for(let y = 1; y <= z; y++){
        //   this.quantityAmt.push(y)
        // }
      // for (let quantity of data){
      // this.itemnumber.push(quantity.available_quantity);
      //   for (let x = 0; x<this.itemnumber.length; x++){
      //     for (let y = 0; y<this.itemnumber.length; y++){
      //       if (y == x){
      //       this.itemnumber2[y] = new Array(this.itemnumber[x]).fill(0).map((x, i)=>i+1);
      //       }
      //     }
      //   }
      // }

        // console.log(this.itemnumber)
        // console.log(this.quantityAmt)
        // console.log(this.itemnumber2)
        console.log(this.product); 
      }, 

      //In case of errors set product object to null
      ()=>{ this.product = null;
        console.log("NO PRODUCT FOUND")
      }

    )

  }

  // getQuantity(quantity: number):void {
  //   this.quantityAmt = [];

  //   this.ps.getSingleProduct2(quantity).subscribe(

  //     (data:any) => {
  //       let response:String = data.status

  //       this.product = data; 

  //       let x =this.product.available_quantity

  //       for(let y = 1; y <= x; y++){
  //         this.quantityAmt.push(y)
  //       }
        
  //       console.log(this.product); //This works
  //       // console.log(response);

  //       console.log(this.quantityAmt);

  //     }, 

      //In case of errors set product object to null
  //     ()=>{

  //       console.log("NO PRODUCT FOUND")

  //     }

  //   )


  // }

  getSingleProduct(product_id:any):void{
    
    this.ps.getSingleProduct2(product_id).subscribe(

      (data:any) => {
        let response:String = data.status
        // this.selectedquantity
        this.product = data; 
        let valueid = this.product.id1;
        let valuequantity = this.product.available_quantity;
        // var e = (document.getElementById("quantityselected")) as HTMLSelectElement;
        // var sel = e.selectedIndex;
        // var opt = e.options[sel];
        // var CurValue = (<HTMLOptionElement>opt).value;
        // var CurText = (<HTMLOptionElement>opt).text;
      
        let index = this.ps.getAllProducts.findIndex(object => object.id1 === valueid);
        if (index === -1){
        if (valuequantity != 0){
        this.ps.getAllProducts.push(this.product); 
        // this.ps.getAllProducts.push(this.ps.ownId); 
        }
      }
        
        console.log(this.product); //This works
        // console.log(response);
        // console.log(CurValue)
        // console.log(CurText)
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
