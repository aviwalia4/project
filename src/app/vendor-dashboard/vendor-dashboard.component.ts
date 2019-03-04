import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vendor-dashboard',
  templateUrl: './vendor-dashboard.component.html',
  styleUrls: ['./vendor-dashboard.component.css']
})
export class VendorDashboardComponent implements OnInit {

  constructor(private router:ActivatedRoute) { }

  ngOnInit() {
    let venid = this.router.snapshot.params.id;
    localStorage.setItem('venId', venid);
  }

}
