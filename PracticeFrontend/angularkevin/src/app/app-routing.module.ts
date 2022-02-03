import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryAleComponent } from './components/category-ale/category-ale.component';
import { CategoryStoutComponent } from './components/category-stout/category-stout.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [

  {
    path:"home",
    component: HomeComponent
  },

  {
    path:"ale",
    component: CategoryAleComponent
  },

  {
    path:"stout",
    component: CategoryStoutComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
