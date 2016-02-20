import {Injectable}     from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Observable}     from 'rxjs/Observable';

import {Hero}           from './hero';

@Injectable()
export class HeroService
{
  constructor(private http:Http)
  {
  }

  private _heroesUrl = 'http://localhost:8080/heroes';

  getHeroes()
  {
    return this.http.get(this._heroesUrl)
      .toPromise()
      .then(res => <Hero[]> res.json(), this.handleError)
      .then(data =>
            {
              console.log(data);
              return data;
            });
  }

  getHero(id:number)
  {
    return this.http.get(this._heroesUrl + '/' + id)
      .toPromise()
      .then(res => <Hero> res.json(), this.handleError)
      .then(data =>
            {
              console.log(data);
              return data;
            }); 

  }

  private handleError(error:any)
  {
    console.error(error);
    return Promise.reject(error.message
                          || error.json().error
                          || 'Server error');
  }
}

