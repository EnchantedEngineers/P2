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
  public id :number=2;


  constructor(private ps:ProductsService) { }

  getProducts():void{

    // this.ps.getProductsFromApiAle().subscribe(
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

  ngOnInit(): void {
    this.getProducts(); 
  }

  

}
