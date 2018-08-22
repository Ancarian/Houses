import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router} from '@angular/router';
import * as JWT from 'jwt-decode';
import {AuthService} from "./auth.service";
import {JwtService} from "./jwt.service";
import {TokenPayLoad} from "../model/model";

@Injectable()
export class RoleGuardService implements CanActivate {
  constructor(public auth: AuthService, public router: Router, private jwtService: JwtService) {
  }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRole = route.data.expectedRole;
    if (!this.auth.isAuthenticated()) {
      this.router.navigate(['forbidden']);
      return false;
    }
    const payload = new TokenPayLoad(JWT(this.jwtService.getToken()));
    if (!payload.authorities.includes(expectedRole)) {
      this.router.navigate(['forbidden']);
      return false;
    }
    return true;
  }
}



