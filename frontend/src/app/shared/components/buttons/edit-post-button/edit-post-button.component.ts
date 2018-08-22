import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormPostDialogueComponent} from "../../dialogue/form-post-dialogue/form-post-dialogue.component";
import {Post} from "../../../../core/model/model";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-edit-post-button',
  templateUrl: './edit-post-button.component.html'
})
export class EditPostButtonComponent implements OnInit {
  modalRef: BsModalRef;
  @Input() post: Post;
  @Output() updated = new EventEmitter<Post>();

  constructor(private modalService: BsModalService) {
  }

  ngOnInit() {
  }

  editForm() {
    this.modalRef = this.modalService.show(FormPostDialogueComponent, {
      initialState: {
        title: this.post ? 'edit post ' + this.post.title : "save post",
        data: this.post
      }
    });
    this.modalRef.content.action.subscribe((post) => {
      this.updated.emit(post);
    });
  }
}
