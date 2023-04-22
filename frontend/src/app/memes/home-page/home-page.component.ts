import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import MemeInterface from '../../interfaces/meme.interface';
import { MemesService } from '../../services/memes.service';

@Component({
    selector: 'app-home-page',
    templateUrl: './home-page.component.html',
    styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {
    memes$: Observable<MemeInterface[]> = this.memesService.memes$;

    constructor(private memesService: MemesService) { };

    memeTrackBy(index: number, meme: MemeInterface) {
        return meme.id;
    }
}
