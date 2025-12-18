import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-register',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent {
    user = { username: '', email: '', password: '', fullName: '' };
    errorMessage = '';

    constructor(private authService: AuthService, private router: Router) { }

    register(): void {
        this.authService.register(this.user).subscribe({
            next: () => this.router.navigate(['/login']),
            error: err => this.errorMessage = 'Registration failed'
        });
    }
}
