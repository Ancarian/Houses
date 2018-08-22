import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../core/services/auth.service";
import {Login} from "../../core/model/model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  isEmailOrPasswordIncorrect: boolean = false;
  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.initForm();
  }


  initForm() {
    const stringValidator = Validators.pattern(new RegExp('^[a-zA-Z0-9_]{2,20}$'));
    const emailValidator = Validators.pattern(new RegExp('^[a-zA-Z0-9_]{3,20}@[a-z]+\\.[a-z]{2,6}$'));
    this.loginForm = this.fb.group({
      password: ['', [
        Validators.required, stringValidator]
      ],
      email: ['example@example.com', [
        Validators.required, emailValidator]
      ]
    });
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.loginForm.controls[controlName];
    return control.invalid && control.touched;
  }

  onSubmit() {
    this.authService.login(new Login(this.loginForm.controls['email'].value, this.loginForm.controls['password'].value))
      .subscribe(
        data => this.router.navigateByUrl('/'),
        err => {
          this.isEmailOrPasswordIncorrect = true;
        }
      );
  }
}
