import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundComponent} from "./shared/components/errors/not-found/not-found.component";
import {IndexComponent} from "./shared/components/index/index.component";
import {ForbiddenComponent} from "./shared/components/errors/forbidden/forbidden.component";


const routes: Routes = [
  {path: '', component: IndexComponent},
  {path: '404', component: NotFoundComponent},
  {path: 'forbidden', component: ForbiddenComponent},
  {path: '**', redirectTo: '404'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
