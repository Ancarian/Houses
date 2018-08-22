import {Component, OnInit} from '@angular/core';
import {ValidService} from "./core/services/valid.service";
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  isValid: boolean;

  constructor(private validService: ValidService, private router: Router) {
  }

  ngOnInit(): void {
    this.isCanShowed();
  }

  isCanShowed() {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.isValid = this.validService.isCanShowed();
      }
    });
  }
}
