import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { RouterModule } from '@angular/router';
import { UserSignupComponent } from './user-signup/user-signup.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { FindFriendsComponent } from './find-friends/find-friends.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UploadMediaComponent } from './upload-media/upload-media.component';

@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    UserSignupComponent,
    UserHomeComponent,
    FindFriendsComponent,
    UserProfileComponent,
    UploadMediaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: UserLoginComponent , pathMatch:'full'},
      {path:'usersignup',component:UserSignupComponent},
      {path:'userlogin',component:UserLoginComponent},
      {path:'userhome',component:UserHomeComponent},
      {path:'findfriends',component:FindFriendsComponent},
      {path:'profile',component:UserProfileComponent},
      {path:'uploadmedia',component:UploadMediaComponent}

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
