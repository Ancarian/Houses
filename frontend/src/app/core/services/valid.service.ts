import {Router} from "@angular/router";
import {Injectable} from "@angular/core";

@Injectable()
export class ValidService {
  private blackList = ['/login', '/sign-up', '/404'];

  constructor(private router: Router) {
  }

  isCanShowed(): boolean {
    return !this.blackList.includes(this.router.url);
  }
}
