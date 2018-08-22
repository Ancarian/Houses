import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProfileRoutingModule} from './profile-routing.module';
import {UserPostsComponent} from "./user-posts/user-posts.component";
import {ProfileComponent} from "./profile.component";
import {SettingsComponent} from './settings/settings.component';
import {SharedModule} from "../../../shared/shared.module";


@NgModule({
  imports: [
    CommonModule,
    ProfileRoutingModule,
    SharedModule
  ],
  declarations: [ProfileComponent, SettingsComponent, UserPostsComponent]
})
export class ProfileModule {
}
