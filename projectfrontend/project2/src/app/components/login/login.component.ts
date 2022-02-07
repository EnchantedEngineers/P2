import { Component, OnInit, ViewChild } from '@angular/core';
import { Address } from 'src/app/models/Address';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public success: any;

  staticAlertClosed = false;
  successMessage = '';
  login_shown: boolean = true;
  login_msg: String = "";
  login_class: String = "";

  //MODAL WITH TIMEOUT FUNCTIONALITY -- STILL WORKING ON IT
  // @ViewChild('staticAlert', {static: false}) staticAlert: NgbAlert;
  // @ViewChild('selfClosingAlert', {static: false}) selfClosingAlert: NgbAlert;

  constructor(private ps: ProductsService) { }

  activeClass = false;

  ngOnInit(): void {

    //MODAL WITH TIMEOUT FUNCTIONALITY -- STILL WORKING ON IT
    // setTimeout(() => this.staticAlert.close(), 20000);

    // this._success.subscribe(message => this.successMessage = message);
    // this._success.pipe(debounceTime(5000)).subscribe(() => {
    //   if (this.selfClosingAlert) {
    //     this.selfClosingAlert.close();
    //   }
    // });

  }

  toggleClass() {
    this.activeClass = !this.activeClass
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

  login(): void {
    this.ps.login(this.username, this.password).subscribe(
      (data: any) => {
        this.success = data;
        this.login_shown = !this.login_shown;
        this.login_class = "alert alert-success";
        this.login_msg = "Login Successful!";
        console.log("Successful Login")
        console.log(this.success)


      },
      () => {
        console.log("Logging In Failed")
        this.login_shown = !this.login_shown;
        this.login_msg = "Login Failed. Incorrect Username or Password!";
        this.login_class = "alert alert-danger";
      }
    )
  };

  Register(): void {
    /**this.ps.Register(this.username, this.password, this.firstname, this.lastname, this.email_address, this.address, this.city, this.state,  this.country, this. postal_code).subscribe(**/
    this.ps.Register(
      this.username, this.password, this.first_name, this.last_name, this.email_address, this.address).subscribe(
        (data: any) => {
          this.login_shown = !this.login_shown;
          this.login_class = "alert alert-success";
          this.login_msg = "Registration Successful!";
          console.log("New Profile Registered")
          this.success = data;
          console.log(this.success)
        },
        () => {
          console.log("Registration Failed")
          this.login_shown = !this.login_shown;
          this.login_msg = "Username is not unique!";
          this.login_class = "alert alert-danger";
        }
      )
  }

}
