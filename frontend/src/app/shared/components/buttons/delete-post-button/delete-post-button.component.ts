import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DeletePostDialogueComponent} from "../../dialogue/delete-post-dialogue/delete-post-dialogue.component";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Post} from "../../../../core/model/model";

@Component({
  selector: 'app-delete-post-button',
  templateUrl: './delete-post-button.component.html'
})
export class DeletePostButtonComponent implements OnInit {
  modalRef: BsModalRef;
  @Input() post: Post;
  @Output() deleted = new EventEmitter();

  constructor(private modalService: BsModalService) {
  }

  ngOnInit() {
  }


  openModal() {
    this.modalRef = this.modalService.show(DeletePostDialogueComponent, {
      initialState: {
        title: 'delete post ' + this.post.title,
        data: this.post
      }
    });
    this.modalRef.content.action.subscribe(() => {
      this.deleted.emit();
    });
  }
}
