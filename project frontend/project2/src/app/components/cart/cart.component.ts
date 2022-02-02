import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor() { }

  getSingleProduct(id:number):void{

//Start add to cart functionality
    // this.ps.getSingleProduct2(id).subscribe(

    //   (data:any) => {
    //     let response:String = data.status

    //     this.product = data; 
    //     console.log(this.product); 
    //   }, 

    //   //In case of errors set product object to null
    //   ()=>{

    //   }

    // )

  }


  ngOnInit(): void {
  }

}
