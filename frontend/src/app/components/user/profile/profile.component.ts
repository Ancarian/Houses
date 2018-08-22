import {Component, OnInit} from '@angular/core';
import {PostRegistration, User} from "../../../core/model/model";
import {UserService} from "../../../core/services/user.service";
import {PostService} from "../../../core/services/post.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html'
})
export class ProfileComponent implements OnInit {
  user: User;

  constructor(private userService: UserService, private postService: PostService, private router: Router) {
  }

  ngOnInit() {
    this.loadProfile();
  }

  private loadProfile() {
    this.userService.getProfile()
      .subscribe(
        data => {
          console.log(data);
          this.user = data
        },
        err => {
        }
      );
  }

  save(post: PostRegistration) {
    this.postService.savePost(post).subscribe(data => {
      this.router.navigate(['/post/' + data.id])
    })
  }
}
