import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {RouterModule} from "@angular/router";
import {NotFoundComponent} from './components/errors/not-found/not-found.component';
import {IndexComponent} from './components/index/index.component';
import {FieldErrorDisplayComponent} from "./components/field-error-display/field-error-display.component";
import {HttpClientModule} from "@angular/common/http";
import {LogoComponent} from './components/logo/logo.component';
import {CountriesComponent} from './components/countries/countries.component';
import {StatesComponent} from './components/states/states.component';
import {CitiesComponent} from './components/cities/cities.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CoreModule} from "../core/core.module";
import {CountrySearchPipe} from "../core/pipes/country-search.pipe";
import {StateService} from "../core/services/state.service";
import {NameSearchPipe} from "../core/pipes/name-search.pipe";
import {CityService} from "../core/services/city.service";
import {AllPostsComponent} from "./components/all-posts/all-posts.component";
import {PostListElementComponent} from "./components/post-list-element/post-list-element.component";
import {PaginationComponent} from './components/pagination/pagination.component';
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {FiltrationComponent} from './components/filtration/filtration.component';
import {BrowserModule} from "@angular/platform-browser";
import {DeletePostDialogueComponent} from './components/dialogue/delete-post-dialogue/delete-post-dialogue.component';
import {BsModalService, ModalModule} from "ngx-bootstrap";
import {SortComponent} from './components/sort/sort.component';
import {FormPostDialogueComponent} from './components/dialogue/form-post-dialogue/form-post-dialogue.component';
import {DeletePostButtonComponent} from './components/buttons/delete-post-button/delete-post-button.component';
import {EditPostButtonComponent} from './components/buttons/edit-post-button/edit-post-button.component';
import {PostFormComponent} from "./components/forms/post-form/post-form.component";
import {ForbiddenComponent} from './components/errors/forbidden/forbidden.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    CoreModule,
    NgxDatatableModule,
    BrowserModule,
    ReactiveFormsModule,
    ModalModule.forRoot()
  ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    NotFoundComponent,
    IndexComponent,
    FieldErrorDisplayComponent,
    LogoComponent,
    CountriesComponent,
    StatesComponent,
    CitiesComponent,
    AllPostsComponent,
    PostListElementComponent,
    PaginationComponent,
    FiltrationComponent,
    DeletePostDialogueComponent,
    SortComponent,
    FormPostDialogueComponent,
    DeletePostButtonComponent,
    EditPostButtonComponent,
    PostFormComponent,
    ForbiddenComponent],
  exports: [
    HeaderComponent,
    FooterComponent,
    FieldErrorDisplayComponent,
    CountriesComponent,
    StatesComponent,
    CitiesComponent,
    AllPostsComponent,
    PostListElementComponent,
    PaginationComponent,
    LogoComponent,
    DeletePostButtonComponent,
    EditPostButtonComponent,
    PostFormComponent,
    ForbiddenComponent],
  entryComponents: [
    DeletePostDialogueComponent,
    FormPostDialogueComponent],
  providers: [CountrySearchPipe, NameSearchPipe, StateService, CityService, BsModalService]
})
export class SharedModule {
}
