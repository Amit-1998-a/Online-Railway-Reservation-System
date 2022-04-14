import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Trains {
  constructor(
    public  trainid: number,
    public  train_name: String,
    public  from: String,
    public  to: String,
    public  fare: number,
    public  berths:number
  ) {
  }
}

@Injectable({
  providedIn: 'root'
})

export class TraindataService{
  [x: string]: any;
  constructor(
    private httpClient: HttpClient
  ) { }

  getTrains(){
      console.log('Test Call');
      return this.httpClient.get<Trains[]>('http://localhost:8083/Admin/Trains');
  }
  
  updateResto(data:any)
  {
    return this.httpClient.post<Trains[]>('http://localhost:8083/Admin/regexfrom',data)
  }

  updateRest(data:any)
  {
    return this.httpClient.post<Trains[]>('http://localhost:8083/Admin/regexto',data)
  }

} 