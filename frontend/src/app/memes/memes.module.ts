import { NgModule } from '@angular/core';
import { MemePageComponent } from './meme-page/meme-page.component';
import { WaitingRoomPageComponent } from './waiting-room-page/waiting-room-page.component';
import { SharedModule } from '../shared/shared.module';
import { HomePageComponent } from './home-page/home-page.component';

@NgModule({
    declarations: [
        MemePageComponent,
        WaitingRoomPageComponent,
        HomePageComponent
    ],
    imports: [
        SharedModule
    ],
    exports: [
        MemePageComponent,
        WaitingRoomPageComponent,
        HomePageComponent,
    ]
})
export class MemesModule { }
