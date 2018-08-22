import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {PostRegistration} from "../../../core/model/model";
import {Validators} from "@angular/forms";

@Component({
  selector: 'app-all-posts',
  templateUrl: './all-posts.component.html'
})
export class AllPostsComponent implements OnInit {
  @Input() posts: any[];
  @Input() isShow: boolean;
  @Output() isDeleted = new EventEmitter();
  @Output() updated = new EventEmitter<PostRegistration>();
  modalRef: BsModalRef;
  columns = [{name: 'RoomsCount'}, {name: 'price'}, {name: 'postType'}, {name: 'buildingType'}];
  stringValidator = Validators.pattern(new RegExp('^[a-zA-Z0-9_]{2,20}$'));
  numberValidator = Validators.pattern(new RegExp('^[1-9][0-9]*$'));
  settings = [
    {type: '>', value: 'roomsCount', additionalTitle: 'from', validators: [this.numberValidator]},
    {type: '<', value: 'roomsCount', additionalTitle: 'to', validators: [this.numberValidator]},
    {type: '>', value: 'price', additionalTitle: 'from', validators: [this.numberValidator]},
    {type: '<', value: 'price', additionalTitle: 'to', validators: [this.numberValidator]},
    {type: ':', value: 'title', additionalTitle: '', validators: [this.stringValidator]}
  ];

  sortSettings = [
    {type: 'asc', value: 'price'},
    {type: 'desc', value: 'price'},
    {type: 'asc', value: 'roomsCount'},
    {type: 'desc', value: 'roomsCount'}
  ];

  constructor(private modalService: BsModalService) {
  }

  deleted() {
    this.isDeleted.emit(true);
  }

  isUpdated(post) {
    this.updated.emit(post);
  }

  ngOnInit(): void {
  }
}
