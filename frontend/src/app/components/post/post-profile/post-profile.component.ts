import {Component, OnInit} from '@angular/core';
import {PostService} from "../../../core/services/post.service";
import {ActivatedRoute} from "@angular/router";
import {Post} from "../../../core/model/model";

@Component({
  selector: 'app-post-profile',
  templateUrl: './post-profile.component.html'
})
export class PostProfileComponent implements OnInit {
  post: Post;

  constructor(private postService: PostService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.loadPost();
  }

  loadPost() {
    this.postService.getPost(this.route.snapshot.params['id']).subscribe(
      data => {
        console.log(data);
        this.post = data;
      }
    )
  }
}
