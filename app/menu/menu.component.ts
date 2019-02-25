import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent implements OnInit, OnDestroy {
  private menuService: MenuService;
  private menu;
  constructor(menuService:MenuService) {
    this.menuService = menuService;
  }
  ngOnInit() {
    this.menuService.getAllMenu()
    .subscribe(response=> {
      this.menu = response;
    })
  }
  ngOnDestroy() {
    console.log('CALLED BEFORE DESTROYING THE COMPONENT.');
  }
}

