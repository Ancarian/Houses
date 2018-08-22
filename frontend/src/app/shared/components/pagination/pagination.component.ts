import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html'
})
export class PaginationComponent implements OnInit {

  @Input() first: boolean;
  @Input() totalPages: number;
  @Input() number: number;
  @Input() last: boolean;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  setPage(page: number) {
    this.router.navigate([this.router.url.split('?')[0]], {queryParams: {page: page}, queryParamsHandling: 'merge'});
  }

  isCanNext() {
    return !this.last;
  }

  isCanPrevious() {
    return !this.first;
  }

  nextFivePages() {
    return this.totalPages - this.number > 6 ? 6 : this.totalPages - this.number;
  }

  previousFivePages() {
    return this.number - 5 > 0 ? 5 : this.number;
  }

  numberRange(position) {
    return this.createArray(this.nextFivePages() + this.previousFivePages(), this.number - this.previousFivePages() + 1);
  }

  private createArray(end, start) {
    return Array.apply(0, Array(end))
      .map(function (element, index) {
        return index + start;
      });
  }

}
