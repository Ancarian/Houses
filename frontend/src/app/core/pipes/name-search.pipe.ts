import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'nameSearch'
})
export class NameSearchPipe implements PipeTransform {

  transform(countries: any[], search: string) {

    if (search === undefined || search.length == 0) {
      return countries
    }
    return countries.filter(it => {
      return it.name.toLowerCase().includes(search);
    });
  }
}
