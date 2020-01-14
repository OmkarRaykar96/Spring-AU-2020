import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewFormComponent } from './Components/new-form/new-form.component';
import { UserViewComponent } from './Components/user-view/user-view.component';
import { NotFoundComponent } from './Components/not-found/not-found.component';

const routes: Routes = [
  {path:'',redirectTo:'/newForm',pathMatch:"full"},
  {path:'newForm', component: NewFormComponent},
  {path:'userView', component: UserViewComponent},
  {path:'**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
