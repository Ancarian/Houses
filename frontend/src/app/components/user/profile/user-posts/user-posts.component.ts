import {Component, OnInit} from '@angular/core';
import {Post, PostRegistration} from "../../../../core/model/model";
import {PostService} from "../../../../core/services/post.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-user-posts',
  templateUrl: './user-posts.component.html'
})
export class UserPostsComponent implements OnInit {

  posts: Post[];

  constructor(private postService: PostService, private route: ActivatedRoute) {
  }

  isDeleted() {
    this.ngOnInit();
  }

  isUpdated(post: PostRegistration) {
    console.log(post);
    this.postService.updatePost(post).subscribe(
      data => {
        this.ngOnInit();
      }, err => {
        console.log(err)
      }
    )
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.loadPost(params);
    });
  }

  loadPost(params) {
    this.postService.getUserPosts(params).subscribe(
      data => {
        this.posts = data;
      }, err => {
        console.log(err)
      }
    )
  }
}
