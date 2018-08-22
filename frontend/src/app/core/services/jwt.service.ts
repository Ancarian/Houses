import {Injectable} from "@angular/core";

@Injectable()
export class JwtService {

  getToken(): string {
    return localStorage['token'];
  }

  saveToken(token: string) {
    localStorage['token'] = token;
  }

  destroyToken() {
    localStorage.removeItem('token');
  }
}
