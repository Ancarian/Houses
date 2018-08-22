import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../../core/services/auth.service";
import {UserRegistration} from "../../core/model/model";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html'
})
export class SignUpComponent implements OnInit {
  loginForm: FormGroup;
  user: UserRegistration;
  isEmailOrPhoneExists = false;

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.user = new UserRegistration();
    this.initForm();
  }

  onChangeCity(id: number) {
    this.loginForm.controls['cityId'].setValue(id);
  }

  reset(state: boolean) {
    this.loginForm.controls['cityId'].reset();
  }

  initForm() {
    const stringValidator = Validators.pattern(new RegExp('^[a-zA-Z0-9_]{2,20}$'));
    const phoneValidator = Validators.pattern(new RegExp('^[0-9]{2,20}$'));
    const emailValidator = Validators.pattern(new RegExp('^[a-zA-Z0-9_]{3,20}@[a-z]+\\.[a-z]{2,6}$'));
    const numberValidator = Validators.pattern(new RegExp('^[1-9][0-9]*$'));
    this.loginForm = this.fb.group({
      password: ['', [
        Validators.required, stringValidator]
      ],
      email: ['example@example.com', [
        Validators.required, emailValidator]
      ],
      phone: ['', [
        Validators.required, phoneValidator]
      ],
      name: ['', [
        Validators.required, stringValidator]
      ],
      lastname: ['', [
        Validators.required, stringValidator]
      ],
      cityId: ['', [
        Validators.required, Validators.min(1), numberValidator]
      ],
    });
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.loginForm.controls[controlName];
    return control.invalid && control.touched;
  }

  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({onlySelf: true});
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }

  onSubmit() {
    if (!this.loginForm.valid) {
      this.isEmailOrPhoneExists = false;
      this.validateAllFormFields(this.loginForm);
      return;
    }

    this.authService.registration(this.loginForm.value)
      .subscribe(
        data => this.router.navigateByUrl('/login'),
        err => {
          this.isEmailOrPhoneExists = true;
        }
      );
  }
}
