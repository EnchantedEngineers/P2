import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { BeersComponent } from './components/beers/beers.component';
import { HttpClientModule } from '@angular/common/http';
import { StoutOneComponent } from './components/stout-one/stout-one.component';
import { StoutTwoComponent } from './components/stout-two/stout-two.component';
import { StoutThreeComponent } from './components/stout-three/stout-three.component';
import { StoutFourComponent } from './components/stout-four/stout-four.component';
import { StoutFiveComponent } from './components/stout-five/stout-five.component';
import { AleOneComponent } from './components/ale-one/ale-one.component';
import { AleTwoComponent } from './components/ale-two/ale-two.component';
import { AleThreeComponent } from './components/ale-three/ale-three.component';
import { AleFourComponent } from './components/ale-four/ale-four.component';
import { AleFiveComponent } from './components/ale-five/ale-five.component';
import { FooterComponentComponent } from './components/footer-component/footer-component.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CartComponent } from './components/cart/cart.component';
import { CategoryStoutComponent } from './components/category-stout/category-stout.component';
import { CategoryAleComponent } from './components/category-ale/category-ale.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    BeersComponent,
    StoutOneComponent,
    StoutTwoComponent,
    StoutThreeComponent,
    StoutFourComponent,
    StoutFiveComponent,
    AleOneComponent,
    AleTwoComponent,
    AleThreeComponent,
    AleFourComponent,
    AleFiveComponent,
    FooterComponentComponent,
    ProfileComponent,
    CartComponent,
    CategoryStoutComponent,
    CategoryAleComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
