import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-filtration',
  templateUrl: './filtration.component.html'
})
export class FiltrationComponent implements OnInit {
  @Input() settings = [];
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) {
  }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    let group = [];
    this.settings.forEach(setting => {
      const control = new FormControl();
      control.setValidators(setting.validators);
      group[setting.value + setting.additionalTitle] = control;
    });
    this.loginForm = this.fb.group(group);
  }

  submit() {
    let search = "";
    this.settings.forEach(setting => {
      if (this.loginForm.controls[setting.value + setting.additionalTitle].value) {
        search += setting.value + setting.type + this.loginForm.controls[setting.value + setting.additionalTitle].value + ",";
      }
    });

    if (search != '') {
      search = search.slice(0, search.length - 1);
      this.setPage(search);
    }
  }

  clear() {
    this.loginForm.reset();
    this.setPage("");
  }

  setPage(search: string) {
    if (search.length != 0) {
      this.router.navigate([this.router.url.split('?')[0]], {queryParams: {search: search}});

    } else {
      this.router.navigate([this.router.url.split('?')[0]],);
    }
  }

}
