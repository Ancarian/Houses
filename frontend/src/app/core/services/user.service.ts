import {Injectable} from '@angular/core';
import {JwtService} from "./jwt.service";
import {ApiService} from "./api.service";
import {User} from "../model/model";
import {Observable} from "rxjs/Observable";
import {map} from "rxjs/operators";

@Injectable()
export class UserService {

  constructor(private jwtService: JwtService, private apiService: ApiService) {
  }

  public getProfile(): Observable<User> {
    return this.apiService.get('/me')
      .pipe(map(
        data => {
          return data;
        }
      ));
  }
}
