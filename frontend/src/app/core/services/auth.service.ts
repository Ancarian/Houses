import {Injectable} from '@angular/core';

import {JwtHelperService} from '@auth0/angular-jwt';
import {JwtService} from "./jwt.service";
import {Login, Token} from "../model/model";
import {map} from "rxjs/operators";
import {Observable} from "rxjs/Observable";
import {ApiService} from "./api.service";


@Injectable()
export class AuthService {
  private helper = new JwtHelperService();

  constructor(private jwtService: JwtService, private apiService: ApiService) {
  }

  public isAuthenticated(): boolean {
    const token = this.jwtService.getToken();
    if (!token) {
      return false;
    }
    return !this.helper.isTokenExpired(token);
  }

  public login(login: Login): Observable<Token> {
    return this.apiService.post('/login', login)
      .pipe(map(
        data => {
          this.setAuth(data);
          return data;
        }
      ));
  }

  public registration(body) {
    return this.apiService.post('/registration', body)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }

  setAuth(token: Token) {
    this.jwtService.saveToken(token.token);
  }

  public logout() {
    this.jwtService.destroyToken();
  }
}
