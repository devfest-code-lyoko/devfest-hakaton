import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../models/User';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  private service = inject(UserService)
  u: User = new User()
  firstname=""
  lastname=""
  username=""
  password=""
  address=""
  mail=""
  type=""
  subscription=""

  message=""

  register(){
    this.u.firstname = this.firstname
    this.u.lastname = this.lastname
    this.u.username = this.username
    this.u.password = this.password
    this.u.address = this.address
    this.u.mail = this.mail
    this.u.type = this.type
    this.u.subscription = this.subscription
    
    this.service.register(this.u).subscribe(data=>{
      if(data==null){
        this.message="Podaci su neispravni"
      } else{
        alert(data.username)
      }
    })
  }
}
