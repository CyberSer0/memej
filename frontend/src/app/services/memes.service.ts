import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, filter, map, retry } from 'rxjs/operators';
import MemeInterface from '../interfaces/meme.interface';

@Injectable({
    providedIn: 'root'
})
export class MemesService {

    memes$: Observable<MemeInterface[]> = this.http.get<MemeInterface[]>('../../api/memes.json').pipe(retry(3), catchError(this.handleError));

    constructor(private http: HttpClient) { }

    getMemeById(id: number): Observable<MemeInterface | undefined> {
        return this.http.get<MemeInterface[]>('../../api/memes.json').pipe(retry(3), catchError(this.handleError), map((data) => { return data.find((el) => el.id == id) }));
    }

    private handleError(error: HttpErrorResponse) {
        if (error.status === 0) {
            console.error('An error occurred:', error.error);
        } else {
            console.error(
                `Backend returned code ${error.status}, body was: `, error.error);
        }
        return throwError(() => new Error('Something bad happened; please try again later.'));
    }
};

