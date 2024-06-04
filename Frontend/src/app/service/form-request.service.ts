import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormRequestService {

  private endpoint = "https://my-json-server.typicode.com/typicode/demo/comments";


  

  constructor(private http: HttpClient) { }

  public getData(): Observable<any> {
    return this.http.get<any>(this.endpoint);
  }

  // public postData(): Observable<any> {
  // return this.http.post<any>(this.endpoint).subscribe(config => {
  //   console.log('Updated config:', config);
  // });}

}
