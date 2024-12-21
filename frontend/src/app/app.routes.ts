import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HelperComponent } from './helper/helper.component';
import { ProvideComponent } from './provide/provide.component';

export const routes: Routes = [
    {path: "register", component: RegisterComponent},
    {path: "login", component: LoginComponent},
    {path: "helper", component: HelperComponent},
    {path: "provide", component: ProvideComponent}
];
