import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserRoutingModule} from './user-routing.module';
import {UserComponent} from './user.component';
import {UserService} from "../../core/services/user.service";
import {AuthGuardService} from "../../core/services/auth-guard.service";

@NgModule({
  imports: [
    CommonModule,
    UserRoutingModule
  ],
  declarations: [UserComponent],
  providers: [AuthGuardService, UserService]
})
export class UserModule {
}
