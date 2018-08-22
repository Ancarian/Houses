import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {City} from "../../../core/model/model";
import {CityService} from "../../../core/services/city.service";

@Component({
  selector: 'app-cities',
  templateUrl: './cities.component.html'
})
export class CitiesComponent implements OnInit {
  selectedStateId: number;
  selected: City;
  cities: City[];
  @Output() voted = new EventEmitter<number>();
  @Output() reseted = new EventEmitter<boolean>();

  constructor(private cityService: CityService) {
  }

  ngOnInit() {
  }

  onShowed(isShowed: boolean) {
    this.cities = null;
    this.selectedStateId = null;
    this.reseted.emit(true);
  }

  onChangeState(id: number) {
    if (id == this.selectedStateId) {
      return
    }
    this.selectedStateId = id;
    this.selected = null;
    this.reseted.emit(true);
    this.initCities(this.selectedStateId);
  }

  initCities(id: number) {
    this.cityService.getCities(id).subscribe(
      data => {
        this.cities = data;
        console.log(this.cities);
      }
    )
  }

  select(city: City) {
    this.selected = city;
    this.voted.emit(city.id);
  }
}
