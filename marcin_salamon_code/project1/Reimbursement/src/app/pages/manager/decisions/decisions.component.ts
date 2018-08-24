import { Component, OnInit } from '@angular/core';
import { DecisionsService } from '../../../services/decisions.service';

@Component({
  selector: 'app-decisions',
  templateUrl: './decisions.component.html',
  styleUrls: ['./decisions.component.css']
})
export class DecisionsComponent implements OnInit {
  decisions = DecisionsService.decisions;
  constructor(private decisionService: DecisionsService) { }

  ngOnInit() {
  }

  managerDecision(): void {
    this.decisionService.managerDecision();
  }
}
