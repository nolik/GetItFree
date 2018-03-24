import {BrowserModule} from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {AdvertListComponent} from './adverts/advert-list.component';
import {AddAdvertComponent} from './adverts/add-advert/add-advert.component';
import {AdvertComponent} from './adverts/advert/advert.component';
import {AdvertDetailComponent} from './adverts/advert-detail/advert-detail.component';
import {DropdownDirective} from './shared/dropdown.directive';
import {AdvertService} from './adverts/advert.service';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {AppRoutingModule} from './app-routing.module';
import {AuthService} from './service/auth.service';
import {ErrorPageComponent} from './error-page/error-page.component';
import {AdvertDetailResolver} from './adverts/advert-detail/advert-detail-resolver.service';
import {AdvertEditComponent} from './adverts/advert-detail/advert-edit/advert-edit.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


import {DataStorageService} from './service/data-storage.service';
import {
  MatButtonModule,
  MatCardModule,
  MatIconModule,
  MatInputModule,
  MatMenuModule,
  MatProgressSpinnerModule,
  MatToolbarModule,
  MatTooltipModule
} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';
import {SignupComponent} from './signup/signup.component';
import {UserService} from './service/user.service';
import {
  AdminGuard,
  GuestGuard,
  LoginGuard
} from './guard';
import {ApiService} from './service/api.service';
import {ConfigService} from './service/config.service';
import {LoginComponent} from './login';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

export function initUserFactory(userService: UserService) {
  return () => userService.initUser();
}

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdvertListComponent,
    AddAdvertComponent,
    AdvertComponent,
    AdvertDetailComponent,
    DropdownDirective,
    ErrorPageComponent,
    AdvertEditComponent,
    PageNotFoundComponent,
    SignupComponent,
    LoginComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatMenuModule,
    MatTooltipModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatToolbarModule,
    MatCardModule,
    MatProgressSpinnerModule,
    FlexLayoutModule
  ],
  providers: [
    LoginGuard,
    GuestGuard,
    AdminGuard,
    AdvertService,
    AuthService,
    ApiService,
    ConfigService,
    AdvertDetailResolver,
    HttpClientModule,
    DataStorageService,
    UserService,
    {
      'provide': APP_INITIALIZER,
      'useFactory': initUserFactory,
      'deps': [UserService],
      'multi': true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
