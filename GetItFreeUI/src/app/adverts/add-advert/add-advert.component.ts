import { Component, OnInit } from '@angular/core';
import {AdvertModel} from '../advert/advert.model';
import {NgForm} from '@angular/forms';
import {AdvertService} from '../advert.service';
import {DataStorageService} from '../../shared/data-storage.service';

@Component({
  selector: 'app-add-advert',
  templateUrl: './add-advert.component.html',
  styleUrls: ['./add-advert.component.css']
})
export class AddAdvertComponent implements OnInit {
  private addedAdvert: AdvertModel;
  constructor(private advertService: AdvertService/*,*/
             /* private dataStorageService: DataStorageService*/) { }

  ngOnInit() {
  }

  onAddAdvert(form: NgForm) {
    const value = form.value;
    const newAdvert = new AdvertModel(undefined, value.name, value.content, new Date, value.imgURL, false);
    // this.dataStorageService.addNewAdvert(newAdvert);
    this.advertService.addAdvert(newAdvert);
  }
}
