import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginModule} from "./login/login.module";
import {AdminModule} from "./admin/admin.module";
import {RouterModule} from "@angular/router";
import {PostModule} from "./post/post.module";
import {UserModule} from "./user/user.module";
import {SignUpModule} from "./sign-up/sign-up.module";
import {ProfileModule} from "./user/profile/profile.module";

@NgModule({
  imports: [
    CommonModule, AdminModule, LoginModule, UserModule, PostModule, SignUpModule, ProfileModule, RouterModule
  ],
  declarations: [],
  exports: []
})
export class ComponentsModule {

}
