import { Component, OnInit } from '@angular/core';
import MemeInterface from "src/app/interfaces/meme.interface";
import { MemesService } from '../../services/memes.service';
import { ActivatedRoute } from '@angular/router';
import CommentInterface from 'src/app/interfaces/comment.interface';
import { map, Observable, tap } from 'rxjs';
import UserInterface from 'src/app/interfaces/user.interface';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-meme-page',
    templateUrl: './meme-page.component.html',
    styleUrls: ['./meme-page.component.scss']
})
export class MemePageComponent implements OnInit {
    meme: MemeInterface | undefined;
    showResponses: boolean = false;
    showAddComment: boolean = false;
    user$: Observable<UserInterface | undefined> = this.userService.user$

    constructor(private memesService: MemesService, private route: ActivatedRoute, private userService: UserService) { };

    memeTrackBy(index: number, meme: MemeInterface) {
        return meme.id;
    }

    ngOnInit(): void {

        let memeId: string | null = null;

        this.route.paramMap.subscribe(params => memeId = params.get("id"));

        if (!memeId || Number.isNaN(memeId)) return;

        this.memesService.getMemeById(memeId).subscribe({ next: (data) => this.meme = data })

    }

    commentsTrackBy(index: number, comment: CommentInterface) {
        return comment.id;
    }

    addComment(event: Event, id: number | null = null): void {
        (event.target as HTMLElement).closest("div")?.innerHTML
    }
}
