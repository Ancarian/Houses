import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Country} from "../../../core/model/model";
import {CountryService} from "../../../core/services/country.service";

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html'
})
export class CountriesComponent implements OnInit {
  countries: Country[];
  selected: Country;
  search: string;
  @Output() voted = new EventEmitter<number>();

  constructor(private countryService: CountryService) {
  }

  ngOnInit() {
    this.loadCountries()
  }

  loadCountries() {
    this.countryService.getCountires().subscribe(
      data => {
        this.countries = data;
      }
    )
  }

  select(country: Country) {
    this.selected = country;
    this.voted.emit(country.id);
  }
}
