import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {

  constructor(private router:ActivatedRoute) { }

  ngOnInit() {
    let id = this.router.snapshot.params.id;
    localStorage.setItem('cusId', id);
  }

}
