import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {LoginRoutingModule} from './login-routing.module';
import {LoginComponent} from './login.component';
import {ReactiveFormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule, LoginRoutingModule, BrowserModule, ReactiveFormsModule, SharedModule
  ],
  declarations: [LoginComponent]
})
export class LoginModule {
}
