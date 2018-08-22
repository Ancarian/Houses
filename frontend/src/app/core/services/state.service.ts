import {Injectable} from '@angular/core';
import {State} from "../model/model";
import {map} from "rxjs/operators";
import {Observable} from "rxjs/Observable";
import {ApiService} from "./api.service";

@Injectable()
export class StateService {

  constructor(private apiService: ApiService) {
  }

  public getStates(id: number): Observable<State[]> {
    return this.apiService.get(`/states/${id}`)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }
}
