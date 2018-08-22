export class TokenPayLoad {
  id: number;
  authorities: string[];
  isAdmin: boolean;

  constructor(tokenPayload) {
    this.id = tokenPayload.id;
    this.authorities = tokenPayload.authorities;
    this.isAdmin = tokenPayload.isAdmin;
  }
}

export class User {
  id: number;
  name: string;
  lastname: string;
  cityUserDto: Adress;
  email: string;
  phone: string;
}


export class Adress {
  city: string;
  state: string;
  country: string;
  adress: string
}

export class Token {
  token: string;
}

export class Login {
  username: string;
  password: string;

  constructor(email: string, password: string) {
    this.username = email;
    this.password = password;
  }
}

export class Country {
  id: number;
  phoneCode: string;
  shortName: string;
  name: string;
}

export class State {
  id: number;
  name: string;
}

export class City {
  id: number;
  name: string;
}


export class UserRegistration {
  name: string;
  lastname: string;
  cityId: number;
  email: string;
  phone: string;
  password: string;
}

export class Post {
  id: number;
  user: User;
  urlOfimages: string[];
  title: string;
  information: string;
  price: number;
  roomsCount: number;
  postType: string;
  buildingType: string;
  adress: Adress;
}

export class PostRegistration {
  id: number;
  user: User;
  urlOfimages: string[];
  title: string;
  information: string;
  price: number;
  roomsCount: number;
  postType: string;
  buildingType: string;
  adress: Adress;
  cityId: number;

  constructor(post: Post) {
    if (!post) {
      return;
    }
    this.id = post.id;
    this.user = post.user;
    this.urlOfimages = post.urlOfimages;
    this.title = post.title;
    this.information = post.information;
    this.price = post.price;
    this.roomsCount = post.roomsCount;
    this.postType = post.postType;
    this.buildingType = post.buildingType;
  }


}
