import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BeersComponent } from './components/beers/beers.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {
    path: "",
   component: HomeComponent

  },
  {
    path: "beers",
   component: BeersComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
