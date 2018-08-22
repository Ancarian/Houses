import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuardService} from "../../core/services/auth-guard.service";
import {UserComponent} from "./user.component";

const routes: Routes = [{
  path: 'user', component: UserComponent, canActivate: [AuthGuardService],

}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule {
}
