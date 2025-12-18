import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
    credentials = { username: '', password: '' };
    errorMessage = '';

    constructor(private authService: AuthService, private router: Router) { }

    login(): void {
        this.authService.login(this.credentials).subscribe({
            next: () => this.router.navigate(['/']),
            error: err => this.errorMessage = 'Login failed'
        });
    }
}
