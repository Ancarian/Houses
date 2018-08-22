import {Injectable} from '@angular/core';
import {ApiService} from "./api.service";
import {Post} from "../model/model";
import {Observable} from "rxjs/Observable";
import {map} from "rxjs/operators";

@Injectable()
export class PostService {

  constructor(private apiService: ApiService) {
  }

  public getPost(id: number): Observable<Post> {
    return this.apiService.get(`/post/${id}`)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }

  public getPosts(params): Observable<Post[]> {
    return this.apiService.get(`/posts`, params)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }

  public getUserPosts(params): Observable<Post[]> {
    return this.apiService.get(`/me/posts`, params)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }

  public deletePost(id: number): Observable<Post> {
    return this.apiService.delete(`/post/${id}`)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }

  public updatePost(body) {
    return this.apiService.put('/post/settings', body)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }

  public savePost(body) {
    return this.apiService.post('/post', body)
      .pipe(map(
        data => {
          return data;
        }
      ));
  }
}
