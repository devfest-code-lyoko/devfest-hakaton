import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from '../models/Service';

@Component({
  selector: 'app-viewservice',
  standalone: true,
  imports: [],
  templateUrl: './viewservice.component.html',
  styleUrl: './viewservice.component.css'
})
export class ViewserviceComponent implements OnInit{
  private router = inject(Router)
  private navig = this.router.getCurrentNavigation()
  seniorUsername = ""
  description = ""
  address = ""
  price = 0
  name = ""
  helperUsername = ""
  service : Service = new Service()

  accepted = true
  

  ngOnInit(): void {
    if(this.navig?.extras?.state){
      this.service = this.navig.extras.state['service']
      this.seniorUsername = this.service.senior_username
      this.description = this.service.description
      this.address = this.service.address
      this.price = this.service.price
      this.name = this.service.name
      if(this.service.helper_username == null){
        this.accepted=false
        this.helperUsername = "The service is not yet accepted"
      } else{
        this.helperUsername = this.service.helper_username
      }
      
       
    }
  }

  back(){

  }

}
