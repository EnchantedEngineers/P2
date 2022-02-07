import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/Address';
import { ProductsService } from 'src/app/services/products.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})


export class ProfileComponent implements OnInit {

  loggedInUser: any = null; 

  
  public success:any;

  constructor(private ps:ProductsService) { }

  ngOnInit(): void {
    this.loginPersist();
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
  } ;

  loginPersist(): void{
    this.ps.login(
      this.ps.username, this.ps.password).subscribe(
    (data:any) => {
      this.loggedInUser = data;
      console.log("User is logged In")
      console.log(this.loggedInUser)
    },
    () => {
      console.log("User Login Failed")
      console.log(this.loggedInUser); 
    }
  )
}
  };



 /**  Register(): void {
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
}*/