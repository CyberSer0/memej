import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MemeComponent } from './meme/meme.component';
import { RouterModule } from '@angular/router';
@NgModule({
    declarations: [MemeComponent],
    imports: [
        CommonModule,
        RouterModule
    ],
    exports: [
        CommonModule,
        MemeComponent
    ]
})
export class SharedModule { }
