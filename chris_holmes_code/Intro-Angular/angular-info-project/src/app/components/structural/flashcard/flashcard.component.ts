import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-flashcard',
    templateUrl: './flashcard.component.html',
    styleUrls: ['./flashcard.component.css']
})
export class FlashcardComponent {
    // To do property binding
    @Input()
    public flashcard;

    public display: boolean = false;

    public toggleAnswer(): void {
        this.display = !this.display;
    }
}