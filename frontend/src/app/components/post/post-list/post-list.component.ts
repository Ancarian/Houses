import {Component, OnInit} from '@angular/core';
import {Post} from "../../../core/model/model";
import {PostService} from "../../../core/services/post.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html'
})
export class PostListComponent implements OnInit {
  posts: Post[];

  constructor(private postService: PostService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      console.log(params);
      this.loadPost(params);
    });
  }

  loadPost(params) {
    this.postService.getPosts(params).subscribe(
      data => {
        this.posts = data;
      }, err => {
        console.log(err)
      }
    )
  }

}
