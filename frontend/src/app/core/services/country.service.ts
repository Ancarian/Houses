import {Injectable} from '@angular/core';
import {ApiService} from "./api.service";
import {map} from "rxjs/operators";
import {Observable} from "rxjs/Observable";
import {Country} from "../model/model";

@Injectable()
export class CountryService {

  constructor(private apiService: ApiService) {
  }

  public getCountires(): Observable<Country[]> {
    return this.apiService.get('/countries')
      .pipe(map(
        data => {
          return data;
        }
      ));
  }
}
