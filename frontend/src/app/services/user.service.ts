import { Injectable } from '@angular/core';
import UserInterface from '../interfaces/user.interface';
import { EMPTY, Observable, catchError, retry, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    constructor(private http: HttpClient) { }

    user$: Observable<UserInterface | undefined> = this.http.get<UserInterface>('../../api/user.json').pipe(retry(3), catchError(() => {
        return EMPTY
    }))

    private handleError(error: HttpErrorResponse) {
        if (error.status === 0) {
            console.error('An error occurred:', error.error);
        } else {
            console.error(
                `Backend returned code ${error.status}, body was: `, error.error);
        }
        return throwError(() => new Error('Something bad happened; please try again later.'));
    }
}
