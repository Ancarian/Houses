import {Pipe, PipeTransform} from '@angular/core';
import {Country} from "../model/model";

@Pipe({
  name: 'countrySearch'
})
export class CountrySearchPipe implements PipeTransform {

  transform(countries: Country[], search: string) {

    if (search === undefined || search.length == 0) {
      return countries
    }
    return countries.filter(it => {
      return it.name.toLowerCase().includes(search) || it.phoneCode.toString().toLowerCase().includes(search);
    });
  }
}
