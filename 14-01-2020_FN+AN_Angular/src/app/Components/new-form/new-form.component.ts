import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { TransferDataService } from 'src/app/Providers/transfer-data.service';

@Component({
  selector: 'app-new-form',
  templateUrl: './new-form.component.html',
  styleUrls: ['./new-form.component.css']
})
export class NewFormComponent implements OnInit {

  constructor(public temp: TransferDataService) { }
 
  ngOnInit() {
    
  }

  profileForm = new FormGroup({
    FirstName: new FormControl('',Validators.required),
    LastName: new FormControl('',Validators.required),
    Email: new FormControl('',Validators.required),
    Contact: new FormControl('',Validators.required)
  });
   
  submitForm(){
      console.log(this.profileForm.value);
      this.temp.setFormData(this.profileForm.value);
      console.log("Submitted: "+this.temp.getFormData());
      this.profileForm.reset();
  } 
}
