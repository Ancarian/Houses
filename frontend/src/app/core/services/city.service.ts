import {Injectable} from '@angular/core';
import {City} from "../model/model";
import {ApiService} from "./api.service";
import {map} from "rxjs/operators";
import {Observable} from "rxjs/Observable";

@Injectable()
export class CityService {

  constructor(private apiService: ApiService) {
  }

  public getCities(id: number): Observable<City[]> {
    return this.apiService.get(`/cities/${id}`)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }

}
