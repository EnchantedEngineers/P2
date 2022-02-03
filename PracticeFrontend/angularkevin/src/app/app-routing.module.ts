import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryAleComponent } from './components/category-ale/category-ale.component';
import { CategoryStoutComponent } from './components/category-stout/category-stout.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [

  {
    path:"home", //""
    component: HomeComponent
  },

  {
    path:"ale", //category-ale
    component: CategoryAleComponent
  },

  {
    path:"stout", //category-stout
    component: CategoryStoutComponent
  },

  {
    path:"login", //profile
    component: LoginComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
