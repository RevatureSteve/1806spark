import { Component } from '@angular/core';

@Component({
  selector: 'app-structural',
  templateUrl: './structural.component.html',
  styleUrls: ['./structural.component.css']
})
export class StructuralComponent {
  title = 'Structural Directive';
  documentation = 'https://angular.io/guide/structural-directives';

  public flashcards = [
    {
      question: 'What is Java?',
      answer: 'Welcome to the Java.'
    },
    {
      question: 'What is Angular?',
      answer: 'Welcome to the Angular.'
    },
    {
      question: 'What is TypeScript?',
      answer: 'Welcome to the TypeScript.'
    },
    {
      question: 'What is a Flashcard?',
      answer: 'Welcome to the Flashcard.'
    }
  ]
}