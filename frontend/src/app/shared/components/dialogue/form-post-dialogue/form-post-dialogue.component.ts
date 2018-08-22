import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BsModalRef} from "ngx-bootstrap";
import {PostService} from "../../../../core/services/post.service";
import {PostRegistration} from "../../../../core/model/model";

@Component({
  selector: 'app-form-post-dialogue',
  templateUrl: './form-post-dialogue.component.html'
})
export class FormPostDialogueComponent implements OnInit {
  @Output() action = new EventEmitter<PostRegistration>();
  title: string;
  data;

  constructor(public modalRef: BsModalRef, private postService: PostService) {
  }

  ngOnInit() {
  }

  updatePost(post: PostRegistration) {
    this.modalRef.hide();
    this.action.emit(post);
  }
}
