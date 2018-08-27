import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agent-missions',
  templateUrl: './agent-missions.component.html',
  styleUrls: ['./agent-missions.component.css']
})
export class AgentMissionsComponent implements OnInit {

missions = [
  { name: 'Skytanic', status: 'Success'},
  {name: 'Honeypot', status: 'Failed'},
  {name: 'Skorpio', status: 'Success'},
   {name: 'Jeu Monegasque', status: 'Success'},
    {name: 'Space Race', status: 'Failed'},
    {name: 'The Papal Chase', status: 'Success'},
    {name: 'Bel Panto', status: 'Failed'},
   {name: 'Deadly Velvet', status: 'Failed'}
];


  constructor() { }

  ngOnInit() {
  }

}
