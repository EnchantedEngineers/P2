import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = "";
  password: string = "";
  public success:any;

  constructor(private ps: ProductService) { }

  ngOnInit(): void {
  }

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
