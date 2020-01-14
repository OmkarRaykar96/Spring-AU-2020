import { Component, OnInit } from '@angular/core';
import { TransferDataService } from 'src/app/Providers/transfer-data.service';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent implements OnInit {

  constructor(public temp2: TransferDataService) { }
  arr2=[]

  deleteRow(i){
    this.temp2.toDelete(i);
  }

  ngOnInit() {
    this.arr2=this.temp2.getFormData();
    console.log(this.temp2.getFormData());
  }
}
