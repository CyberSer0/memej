import { Component, Input, ViewChild, AfterViewInit } from '@angular/core';
import MemeInterface from 'src/app/interfaces/meme.interface';

@Component({
    selector: 'app-meme',
    templateUrl: './meme.component.html',
    styleUrls: ['./meme.component.scss']
})
export class MemeComponent implements AfterViewInit {
    @Input() meme: MemeInterface | undefined;
    @Input() subPage: boolean = false
    @ViewChild("image") img: any | undefined;
    tagTrackBy(index: number, tag: any) {
        return tag.id;
    }

    ngAfterViewInit(): void {
        if (!this.subPage && this.img?.nativeElement.height > 500) {
            this.img.nativeElement.closest("a").classList.add("img--too-large")
        }
    }
}
