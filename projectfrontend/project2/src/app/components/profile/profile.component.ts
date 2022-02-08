import { HttpErrorResponse } from '@angular/common/http';
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


  public success: any;
  public update: any;
  public reg_success: boolean = false; 
  login_class: string = "";
  login_msg: string = "";

  constructor(private ps: ProductsService) { }

  ngOnInit(): void {

  }

  username: string = this.ps.ownuser;
  password: string = this.ps.ownpass;
  first_name: string = this.ps.fn;
  last_name: string = this.ps.ln;
  email_address: string = this.ps.ownemail;
  addressId: number = 0;
  address: Address = {
    id: this.ps.addressId,
    address_1: this.ps.ownAddress,
    city: this.ps.ownCity,
    state: this.ps.ownState,
    country: this.ps.ownCountry,
    postal_code: this.ps.ownCode
  };


  updateUserAddress(): void {
    console.log(this.address);
    this.ps.updateAddress(this.address).subscribe(
      (data: any) => {},
      this.handleError
    )

  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 200) {
      console.log(error.status);
      console.log("REGISTRATION SUCCESS");

      this.reg_success = !this.reg_success;
      this.login_class = "alert alert-success";
      this.login_msg = "Address successfully updated";
    } else {
      console.log(error.status);
      console.log("REGISTRATION UNSUCCESSFUL");

      this.reg_success = !this.reg_success;
      this.login_msg = "Address update was unsuccessful!";
      this.login_class = "alert alert-danger";
    }
  }
}