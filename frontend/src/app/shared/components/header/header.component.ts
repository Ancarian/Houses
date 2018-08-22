import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {JwtService} from "../../../core/services/jwt.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  constructor(private jwtService: JwtService, private router: Router) {
  }

  ngOnInit() {
  }

  getService() {
    return this.jwtService;
  }

  logout() {
    this.jwtService.destroyToken();
    this.router.navigate(['login']);
  }
}
