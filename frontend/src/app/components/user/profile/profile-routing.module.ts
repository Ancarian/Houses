import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfileComponent} from "./profile.component";
import {UserPostsComponent} from "./user-posts/user-posts.component";
import {SettingsComponent} from "./settings/settings.component";
import {AuthGuardService} from "../../../core/services/auth-guard.service";

const routes: Routes = [
  {
    path: 'me', component: ProfileComponent, canActivate: [AuthGuardService], children: [
      {
        path: 'posts',
        component: UserPostsComponent
      },
      {
        path: 'settings',
        component: SettingsComponent
      }]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule {
}
