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
    
  }


}