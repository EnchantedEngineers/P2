import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  ps: any;


  constructor() { }
  activeClass=false;

  ngOnInit(): void {}

  toggleClass(){
    this.activeClass=!this.activeClass
  }


  username: string = "";
  password: string = "";
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
  }

}
