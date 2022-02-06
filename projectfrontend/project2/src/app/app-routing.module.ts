import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BeersComponent } from './components/beers/beers.component';
import { CartComponent } from './components/cart/cart.component';
import { CategoryAleComponent } from './components/category-ale/category-ale.component';
import { CategoryStoutComponent } from './components/category-stout/category-stout.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  {
    path: "",
   component: HomeComponent

  },

  {
    path: "beers",
   component: BeersComponent
  },

  {
    path: "profile",
   component: ProfileComponent
  },

  {
    path: "cart",
   component: CartComponent
  },

  {
    path: "category-ale",
   component: CategoryAleComponent
   
  },

  {
    path: "category-stout",
   component: CategoryStoutComponent
  },

  {
    path: "login",
   component: LoginComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
