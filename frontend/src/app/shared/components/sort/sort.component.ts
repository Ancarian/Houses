import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-sort',
  templateUrl: './sort.component.html',
  styleUrls: ['./sort.component.css']
})
export class SortComponent implements OnInit {
  @Input() settings;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  setPage(control) {
    this.router.navigate([this.router.url.split('?')[0]],
      {
        queryParams: {sorts: control.type + ':' + control.value},
        queryParamsHandling: 'merge'
      });
  }
}
