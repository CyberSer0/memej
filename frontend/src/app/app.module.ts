import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { MemesModule } from './memes/memes.module';

@NgModule({
    declarations: [
        AppComponent,
        ErrorPageComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        MemesModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
