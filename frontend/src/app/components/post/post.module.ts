import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {PostRoutingModule} from './post-routing.module';
import {PostProfileComponent} from './post-profile/post-profile.component';
import {PostListComponent} from './post-list/post-list.component';
import {PostCreateComponent} from './post-create/post-create.component';
import {SharedModule} from "../../shared/shared.module";
import {CountryService} from "../../core/services/country.service";
import {PostService} from "../../core/services/post.service";

@NgModule({
  imports: [
    CommonModule,
    PostRoutingModule,
    SharedModule
  ],
  declarations: [PostProfileComponent, PostListComponent, PostCreateComponent],
  providers: [CountryService, PostService]
})
export class PostModule {
}
