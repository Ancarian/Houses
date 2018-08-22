import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PostProfileComponent} from "./post-profile/post-profile.component";
import {PostListComponent} from "./post-list/post-list.component";
import {PostCreateComponent} from "./post-create/post-create.component";
import {AuthGuardService} from "../../core/services/auth-guard.service";

const routes: Routes = [
  {path: 'post/:id', component: PostProfileComponent},
  {path: 'posts', component: PostListComponent},
  {path: 'post', component: PostCreateComponent, canActivate: [AuthGuardService]}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class PostRoutingModule {
}
