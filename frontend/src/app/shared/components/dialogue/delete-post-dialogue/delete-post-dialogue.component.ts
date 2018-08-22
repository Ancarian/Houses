import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BsModalRef} from "ngx-bootstrap";
import {PostService} from "../../../../core/services/post.service";

@Component({
  selector: 'app-delete-post-dialogue',
  templateUrl: './delete-post-dialogue.component.html',
})
export class DeletePostDialogueComponent implements OnInit {
  @Output() action = new EventEmitter();
  title: string;
  data;

  constructor(public modalRef: BsModalRef, private postService: PostService) {
  }

  ngOnInit() {
  }


  deletePost() {
    this.postService.deletePost(this.data.id).subscribe(data => {
      this.modalRef.hide();
      this.action.emit(true);
    });
  }
}
