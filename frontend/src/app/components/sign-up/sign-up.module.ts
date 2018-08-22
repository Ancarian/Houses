import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SignUpRoutingModule} from './sign-up-routing.module';
import {SignUpComponent} from './sign-up.component';
import {SharedModule} from "../../shared/shared.module";
import {BrowserModule} from "@angular/platform-browser";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    SignUpRoutingModule, BrowserModule, ReactiveFormsModule, SharedModule
  ],
  declarations: [SignUpComponent]
})
export class SignUpModule {
}
