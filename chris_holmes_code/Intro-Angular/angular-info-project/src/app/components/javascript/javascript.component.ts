import { Component } from '@angular/core';
/*
    3 requirements for Component Decorator
        1. selector = directive app-? e.g. app-nav, app-flashcard etc
        2. template or templateUrl - the html for this component
        3. style or stylesUrl - the css for this component
*/
@Component({
    selector: `app-javascript`,
    templateUrl: './javascript.component.html',
    styleUrls: ['./javascript.component.css']
})

export class JavascriptComponent {
    title = 'JavaScript';
}
