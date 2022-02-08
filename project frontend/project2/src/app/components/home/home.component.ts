import { Component, OnInit } from '@angular/core';
import { CarouselConfig } from 'ngx-bootstrap/carousel';

@Component({
   selector: 'app-test',
   templateUrl: './home.component.html',
   providers: [
      { provide: CarouselConfig, useValue: { interval: 1500, noPause: false, showIndicators: true } }
   ],
   styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
   slides = [
      {image: 'assets/beer.jpg', text: 'beer'},
     
      {image: 'assets/newholland.jpg',text: 'new holland'},
      {image: 'assets/torpdeo.jpg',  text: 'Torpedo '}
   ];
   noWrapSlides = false;
   showIndicator = true;
   constructor() { }

   ngOnInit(): void {
   }
}