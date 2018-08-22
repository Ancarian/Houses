import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Post, PostRegistration} from "../../../../core/model/model";

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent implements OnInit {

  loginForm: FormGroup;
  postRegistration: PostRegistration;
  buildingTypes: string[] = ['APARTMENT', 'HOUSE'];
  postTypes: string[] = ['PURCHASE', 'SALE', 'RENTING'];
  @Input() post: Post;
  @Output() updated = new EventEmitter<PostRegistration>();

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    this.postRegistration = new PostRegistration(this.post);
    this.initForm();
  }

  onChangeCity(id: number) {
    this.loginForm.controls['cityId'].setValue(id);
  }

  reset() {
    this.loginForm.controls['cityId'].reset();
  }

  initForm() {
    const stringValidator = Validators.pattern(new RegExp('^[a-zA-Z0-9_]{2,20}$'));
    const adressValidator = Validators.pattern(new RegExp('^[a-zA-Z0-9, ]{2,20}$'));
    const longStringValidator = Validators.pattern(new RegExp('^[\\s\\S]{2,255}$'));
    const numberValidator = Validators.pattern(new RegExp('^[1-9][0-9]*$'));
    this.loginForm = this.fb.group({
      title: [this.postRegistration.title || '', [
        Validators.required, stringValidator]
      ],
      information: [this.postRegistration.information || '', [
        Validators.required, longStringValidator]
      ],
      price: [this.postRegistration.price || '', [
        Validators.required, numberValidator]
      ],
      roomsCount: [this.postRegistration.roomsCount || '', [
        Validators.required, numberValidator]
      ],
      postType: [this.postRegistration.postType || '', [
        Validators.required]
      ],
      buildingType: [this.postRegistration.buildingType || '', [
        Validators.required]
      ],
      adress: ['', [
        Validators.required, adressValidator]
      ],
      cityId: ['', [
        Validators.required, numberValidator]
      ]
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
      this.validateAllFormFields(this.loginForm);
      return;
    }
    this.convertToPost();
    console.log(this.postRegistration);
  }


  convertToPost() {
    Object.keys(this.loginForm.controls).forEach(field => {
      this.postRegistration[field] = this.loginForm.get(field).value;
    });
    this.updated.emit(this.postRegistration);
  }
}
