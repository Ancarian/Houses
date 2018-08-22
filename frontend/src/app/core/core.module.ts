import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UserService} from "./services/user.service";
import {RoleGuardService} from "./services/role-guard.service";
import {ApiService} from "./services/api.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpTokenInterceptor} from "./interceptors/token.interceptor";
import {AuthGuardService} from "./services/auth-guard.service";
import {ValidService} from "./services/valid.service";
import {AuthService} from "./services/auth.service";
import {JwtService} from "./services/jwt.service";
import {RouterModule} from "@angular/router";
import {CountrySearchPipe} from './pipes/country-search.pipe';
import {NameSearchPipe} from './pipes/name-search.pipe';

@NgModule({
  declarations: [CountrySearchPipe, NameSearchPipe],
  imports: [CommonModule, RouterModule, HttpClientModule],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: HttpTokenInterceptor, multi: true},
    AuthGuardService,
    RoleGuardService,
    AuthService,
    ValidService,
    ApiService,
    JwtService,
    UserService],
  exports: [CountrySearchPipe, NameSearchPipe]
})
export class CoreModule {
}
