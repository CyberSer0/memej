import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './memes/home-page/home-page.component';
import { WaitingRoomPageComponent } from './memes/waiting-room-page/waiting-room-page.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { MemePageComponent } from './memes/meme-page/meme-page.component';

const routes: Routes = [
    { path: "", component: HomePageComponent },
    { path: "waiting-room", component: WaitingRoomPageComponent },
    { path: "meme/:id", component: MemePageComponent },
    { path: "**", component: ErrorPageComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
