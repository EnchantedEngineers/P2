import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/Address';
import { ProductsService } from 'src/app/services/products.service';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  constructor(private ps: ProductsService) { }

  login_shown: boolean = true;
  login_msg: String = "";
  login_class: String = "";
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
    id:0,
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

        this.login_shown = !this.login_shown;
        this.login_class = "alert alert-success";
        this.login_msg = "Login Successful!";

        console.log("Successful Login")
        console.log(this.success)
        this.ps.ownId = this.success.id;
        this.ps.fn = this.success.first_name;
        this.ps.ln = this.success.last_name;
        this.ps.ownuser = this.success.username;
        this.ps.ownpass = this.success.password
        this.ps.ownemail = this.success.email_address;
        
        this.ps.addressId = this.success.address.id;
        this.ps.ownAddress = this.success.address.address_1;
        this.ps.ownCity = this.success.address.city;
        this.ps.ownCountry = this.success.address.country;
        this.ps.ownCode = this.success.address.postal_code;
        this.ps.ownState = this.success.address.state;
        
      },
      () => {
        console.log("Logging In Failed")

        this.login_shown = !this.login_shown;
        this.login_msg = "Login Failed. Incorrect Username or Password!";
        this.login_class = "alert alert-danger";
      }
    )
  }

  Register(): void {
    this.ps.Register(
         this.username, this.password, this.first_name, this.last_name, this.email_address, this.address).subscribe(
       (data:any) => {},
       this.handleError
     )
   }
   private handleError(error: HttpErrorResponse) {
    if (error.status === 200) {
      console.log(error.status);
      console.log("REGISTRATION SUCCESS");

      this.login_shown = !this.login_shown;
          this.login_class = "alert alert-success";
          this.login_msg = "Registration Successful!";
    } else {
      console.log(error.status);
      console.log("REGISTRATION UNSUCCESSFUL");

      this.login_shown = !this.login_shown;
      this.login_msg = "Username is not unique!";
      this.login_class = "alert alert-danger";
    }
  }
}
