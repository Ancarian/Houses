import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {StateService} from "../../../core/services/state.service";
import {State} from "../../../core/model/model";

@Component({
  selector: 'app-states',
  templateUrl: './states.component.html'
})
export class StatesComponent implements OnInit {

  states: State[];
  selected: State;
  selectedCountryId: number;
  @Output() voted = new EventEmitter<number>();
  @Output() showed = new EventEmitter<boolean>();

  constructor(private stateService: StateService) {
  }

  ngOnInit() {
  }

  select(state: State) {
    this.selected = state;
    this.voted.emit(state.id);
  }

  onChangeCountry(id: number) {
    if (id == this.selectedCountryId) {
      return
    }
    this.selectedCountryId = id;
    this.selected = null;
    this.showed.emit(false);
    this.initStates(this.selectedCountryId);
  }

  initStates(id: number) {
    this.stateService.getStates(id).subscribe(
      data => {
        this.states = data;
        console.log(this.states);
      }
    )
  }
}
