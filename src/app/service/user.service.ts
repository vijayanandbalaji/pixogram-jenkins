import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:9531/user';

  constructor(private http:HttpClient ) { }

  createUser(user: User): Observable<Object> {
    return this.http.post(`${this.baseUrl}/user/create`, user);
  }

  loginUser(name: String,password: String): Observable<Object> {
    return this.http.get(`${this.baseUrl}/user/login/${name}/${password}`);
  }

  displayfriends() : Observable<User[]>{
    return this.http.get<User[]>(`${this.baseUrl}/display/friends`);
  }
  
}
