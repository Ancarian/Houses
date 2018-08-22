import {Component, OnInit} from '@angular/core';
import {JwtService} from "../../../core/services/jwt.service";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html'
})
export class IndexComponent implements OnInit {

  constructor(private jwtService: JwtService) {
  }

  ngOnInit() {
  }


  getService() {
    return this.jwtService;
  }
}
