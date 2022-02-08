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
  public update: any;

  constructor(private ps:ProductsService) { }

  ngOnInit(): void {
    
  }

  username: string =  this.ps.ownuser;
  password: string =  this.ps.ownpass;
  first_name: string = this.ps.fn;
  last_name: string = this.ps.ln;
  email_address: string = this.ps.ownemail;
  address: Address = {
    id:this.ps.addressId,
    address_1: '',
    city: '',
    state: '',
    country: '',
    postal_code: ''
  };

  // put this in method to update the address

  // this.ps.ownAddress = this.address.address_1;
  // this.this.ps.ownCity = this.address.city;
  // this.ps.ownCountry = this.address.country;
  // this.ps.ownCode = this.address.postal_code;
  // this.ps.ownState = this.address.state; 

  updateUserAddress(): void {
    console.log(this.address);
    this.ps.updateAddress(this.address).subscribe(
      (data:any) => {
        this.update = data;
        console.log("Successfully Updated Address")
        console.log(this.update)
      },
      () => {
        console.log(this.address);
        console.log("Updating User Profile failed")
      }
    )

  }
}