import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {RouterModule} from "@angular/router";
import {SharedModule} from "./shared/shared.module";
import {CoreModule} from "./core/core.module";
import {AppRoutingModule} from "./app-routing.module";
import {ComponentsModule} from "./components/components.module";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, ComponentsModule, SharedModule, CoreModule, RouterModule, AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
