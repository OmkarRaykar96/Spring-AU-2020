import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class TransferDataService {

  constructor() { }

  arr = []
  toDelete(i){
    this.arr.splice(i,1);
  }

  setFormData(obj){
    this.arr.push(obj);
  }
  getFormData(){
    return this.arr;
  }
}
