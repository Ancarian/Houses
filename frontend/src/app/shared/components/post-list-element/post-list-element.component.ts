import {Component, Input, OnInit} from '@angular/core';
import {Post} from "../../../core/model/model";

@Component({
  selector: 'app-post-list-element',
  templateUrl: './post-list-element.component.html'
})
export class PostListElementComponent implements OnInit {
  @Input() post: Post;

  constructor() {
  }

  ngOnInit() {
  }

}
