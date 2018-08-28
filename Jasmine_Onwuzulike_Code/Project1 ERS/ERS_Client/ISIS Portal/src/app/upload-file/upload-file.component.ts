import { UsersService } from './../users-service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent implements OnInit {

  constructor(private httpService : HttpClient, private service: UsersService) { }

  usr = this.service.currentLoggedUser();
  ur = JSON.stringify(this.usr);
  user = this.ur.valueOf();
  final = JSON.parse(this.user);

  ngOnInit() {
  }

  onFileChanged($event) {

  }



}
