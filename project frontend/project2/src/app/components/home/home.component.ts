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
      {image: 'assets/beer.jpg', text: 'First'},
      {image: 'assets/beerdisplay.jpg',text: 'Second'},
      {image: 'assets/home.jpg',text: 'Third'},
      {image: 'assets/torpdeo.jpg',  text: 'Third'}
   ];
   noWrapSlides = false;
   showIndicator = true;
   constructor() { }

   ngOnInit(): void {
   }
}