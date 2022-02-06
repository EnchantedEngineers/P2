import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(){}
ngOnInit(){}
url: string = "../assets/budlight.png";
changeImage(event: any){
  this.url = event.target.src;
  console.log();
}

}
