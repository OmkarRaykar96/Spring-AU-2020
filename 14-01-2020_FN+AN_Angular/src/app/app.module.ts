import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NewFormComponent } from './Components/new-form/new-form.component';
import { UserViewComponent } from './Components/user-view/user-view.component';
import { NotFoundComponent } from './Components/not-found/not-found.component';

import { FormsModule, ReactiveFormsModule }   from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    UserViewComponent,
    NotFoundComponent,
    NewFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
