import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/Address';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  constructor(private ps: ProductsService) { }

  activeClass=false;

  ngOnInit(): void {}

  toggleClass(){
    this.activeClass=!this.activeClass
  }


  username: string = "";
  password: string = "";
  first_name: string = "";
  last_name: string = "";
  email_address: string = "";
  address: Address = {
    address_1: '',
    city: '',
    state: '',
    country: '',
    postal_code: ''
  };
  
  public success:any;

  login():void {
    this.ps.login(this.username, this.password).subscribe(
      (data:any)=> {
        this.success=data;
        console.log("Successful Login")
        console.log(this.success)
      },
      () => {
        console.log("Logging In Failed")
      }
    )
  };

  Register(): void {
    /**this.ps.Register(this.username, this.password, this.firstname, this.lastname, this.email_address, this.address, this.city, this.state,  this.country, this. postal_code).subscribe(**/
       this.ps.Register(
         this.username, this.password, this.first_name, this.last_name, this.email_address, this.address).subscribe(
       (data:any) => {
         this.success = data;
         console.log("New Profile Registered")
         console.log(this.success)
       },
       () => {
         console.log("Registration Failed")
         console.log(this.success); 
       }
     )
   }

}
