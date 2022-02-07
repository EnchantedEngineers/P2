import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/Address';
import { ProductsService } from 'src/app/services/products.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})


export class ProfileComponent implements OnInit {

  constructor(private ps:ProductsService) { }

  ngOnInit(): void {
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


  public success:any;

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
