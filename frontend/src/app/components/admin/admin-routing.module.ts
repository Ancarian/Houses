import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from "./admin/admin.component";
import {RoleGuardService} from "../../core/services/role-guard.service";

const routes: Routes = [{
  path: 'admin', component: AdminComponent, canActivate: [RoleGuardService], data: {
    expectedRole: 'ADMIN'
  }
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {
}
