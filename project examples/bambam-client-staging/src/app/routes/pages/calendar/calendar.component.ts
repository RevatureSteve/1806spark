import { Component, OnInit} from '@angular/core';
import * as $ from 'jquery';
import * as moment from 'moment';
import 'fullcalendar';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  private topics = ['Java', 'SQL', 'Angular', 'JavaScript', 'Spring', 'DevOps',
  'SOAP', 'REST', 'Microservices', 'Docker', 'Amazon Web Services'];

  private subtopics = [];

  private validSubtopic = false;
  private isToday = true;

  // Used for updating the view of the main calendar
  private view: string; // $('#main-calendar').fullCalendar('getView').type;
  private viewDate: Date; // $('#main-calendar').fullCalendar('getDate').toDate();
  private title: string; // $('#main-calendar').fullCalendar('getView').title;

  // Used for datepicker and timepicker
  private date: Date;  // input value for datepicker and timepicker
  private time: Date;

  private events = [
    {
      title: 'Test1',
      start: new Date(),
      description: 'This is a cool event',
      textColor: 'white',
      color: eventColor.blue
    },
    {
      title: 'Test2',
      start: new Date(),
      description: 'This is a cool event',
      textColor: 'white',
      color: eventColor.green
    },
    {
      title: 'Test3',
      start: new Date(),
      description: 'This is a cool event',
      textColor: 'white',
      color: eventColor.red
    },
    {
      title: 'Test4',
      start: new Date(),
      description: 'This is a cool event',
      textColor: 'white',
      color: eventColor.orange
    },
    {
      title: 'Test5',
      start: new Date(),
      description: 'This is a cool event',
      textColor: 'white',
      color: eventColor.blue
    },
    {
      title: 'Test6',
      start: new Date(),
      description: 'This is a cool event',
      textColor: 'white',
      color: eventColor.blue
    }
  ];

  constructor() { }

  ngOnInit() {
    this.configureCalendars();
  }

  /**
   * Returns true if window screen is smaller than 768px.
   */
  private smallScreen(): boolean {
    if (window.innerWidth < 768) {
      return true;
    }
    return false;
  }

  /**
   * Configures the main calendar.
   */
  private configureCalendars() {
    const today = new Date();

    $('#main-calendar').fullCalendar({
      header: false,
      timezone: 'local',
      events: this.events,
      eventLimit: true,
      dayRender: function( date, cell ) {
        // Change background color of today's day
        if (date.format('MM-DD-Y') === moment(today).format('MM-DD-Y')) {
          cell.css('background-color', 'rgb(255, 134, 73)');
        }
      }
    });

    // For the main calendar view
    this.title = $('#main-calendar').fullCalendar('getView').title;
    this.viewDate = $('#main-calendar').fullCalendar('getDate').toDate();
    this.view = $('#main-calendar').fullCalendar('getView').type;

    // For datepicker and timepicker
    this.date = this.viewDate;
    this.time = new Date();
    this.resetTime(this.time);
    this.time.setHours(8);
  }

  /**
   * Changes the calendar view. Available views: day, week, month, list.
   * Also changes view based on: today, prev, next
   * @param value Type of view
   */
  private changeView(view: string) {
    switch (view) {
      case 'day':
        $('#main-calendar').fullCalendar('changeView', 'agendaDay');
        this.view = 'day';
        break;

      case 'week':
        $('#main-calendar').fullCalendar('changeView', 'agendaWeek');
        this.view = 'week';
        break;

      case 'month':
        $('#main-calendar').fullCalendar('changeView', 'month');
        this.view = 'month';
        break;

      case 'list':
        $('#main-calendar').fullCalendar('changeView', 'list');
        this.view = 'list';
        break;

      case 'today':
        $('#main-calendar').fullCalendar('today');
        break;

      case 'prev':
        $('#main-calendar').fullCalendar('prev');
        break;

      case 'next':
        $('#main-calendar').fullCalendar('next');
        break;
    }

    // Set current title and viewDate to reflect changes
    this.title = $('#main-calendar').fullCalendar('getView').title;
    this.viewDate = $('#main-calendar').fullCalendar('getDate').toDate();
    this.date = this.viewDate;

    // Disable or enable the 'Today' button
    if (this.checkToday(this.viewDate)) {
      this.isToday = true;
    } else {
      this.isToday = false;
    }
  }

  /**
   * Sets datepicker input value to current viewDate if dateValue is invalid.
   * Else it jumps to date specified.
   * @param dateValue Object with date
   */
  private dateChange(dateValue) {
    if (!this.isDateValid(dateValue)) {
      this.date = new Date();
      this.date.setTime(this.viewDate.getTime());
    } else {
      this.jumpTo(dateValue);
    }
  }

  /**
   * Resets time of date to 8:00 AM.
   * @param date date Object
   */
  private resetTime(date: Date) {
    date.setHours(8);
    date.setMinutes(0);
    date.setSeconds(0);
    date.setMilliseconds(0);
  }

  /**
   * Updates the time (hour, minutes, seconds. milliseconds)
   * of date1 with the time of date2. Used to update time of
   * datepicker with time of timepicker.
   * @param date1 Date with old time
   * @param date2 Date with new time
   */
  private updateTime(date1: Date, date2: Date): Date {
    date1.setHours(date2.getHours());
    date1.setMinutes(date2.getMinutes());
    date1.setSeconds(date2.getSeconds());
    date1.setMilliseconds(date2.getMilliseconds());
    return date1;
  }

  /**
   * Resets timepicker input value if invalid.
   * @param valid event that returns true if valid or not.
   */
  private timeChange() {
      if (!this.date) {
        this.date = new Date();
        this.date.setTime(this.viewDate.getTime());

        // iterate DOM and remove 'is-invalid' class style
        // this removes the red border in invalid input
        const inputs = document.getElementsByClassName('is-invalid');
        for (let i = 0; i < inputs.length; i++) {
          inputs[i].classList.remove('is-invalid');
        }
      }
  }

  /**
   * Jump to specific date if the date value changes.
   * 'dateValue' is of type object that contains a date -
   * e.g. - Wed Jun 20 2018 18:09:17 GMT-0400 (Eastern Daylight Time)
   * @param dateValue - Object with date
   */
  private jumpTo(dateValue) {
    // this.date contains previous date, dateValue contains new date

    // compare previous date with new date
    if (dateValue) {
      if (this.date.toLocaleDateString() !== (new Date(dateValue).toLocaleDateString())) {
        const date = moment(dateValue);
        $('#main-calendar').fullCalendar('gotoDate', date);
        this.changeView('day');
      }
    }
  }

  /**
   * Returns true if date is valid or not.
   * @param date Date to be checked
   */
  private isDateValid(date): boolean {
    const validDate = new Date(date);

    // Check if date time is a valid number
    if (!isNaN(validDate.getTime())) {
      return true;
    }
    return false;
  }

  /**
   * Returns true if date passed is today's date.
   * @param date Date of type Moment
   */
  private checkToday(date: Date): boolean {
    const today = new Date();
    if (date.toLocaleDateString() === today.toLocaleDateString()) {
      return true;
    }
    return false;
  }

  /**
   * Show or hide the events panel.
   * Modifies some CSS and bootstrap elements of the events panel.
   */
  private clickEventOptions() {
    const events = document.getElementById('event-panel');
    const calendar = document.getElementById('calendar-panel');
    if (events.style.display !== 'inline-block') {
      events.style.display = 'inline-block';
      calendar.classList.remove('col-md-12');
    } else {
      events.style.display = 'none';
      calendar.classList.add('col-md-12');
    }

    // scroll to menu navbar with animation
    $('html, body').animate({
      scrollTop: $('#menu-navbar').offset().top
    }, 500);
  }

  /**
   * Add list of subtopics if a topic is valid.
   */
  private getSubtopics() {
    const topic = (<HTMLInputElement>document.getElementById('topic')).value;
    this.subtopics = [];

    if (topic.toLowerCase() === 'java'.toLowerCase()) {
      this.subtopics.push('Threads');
      this.subtopics.push('Inheritance');
      this.subtopics.push('Collections');
      this.subtopics.push('Maps');
      // this.validSubtopic = true;
      (<HTMLInputElement>document.getElementById('subtopic')).disabled = false;
    } else if (topic.toLowerCase() === 'angular'.toLowerCase()) {
      this.subtopics.push('Directives');
      this.subtopics.push('Observables');
      this.subtopics.push('Data Binding');
      this.subtopics.push('Pipes');
      // this.validSubtopic = true;
      (<HTMLInputElement>document.getElementById('subtopic')).disabled = false;
    } else {
      this.validSubtopic = false;
      (<HTMLInputElement>document.getElementById('subtopic')).value = '';
      (<HTMLInputElement>document.getElementById('subtopic')).disabled = true;
    }
  }

  /**
   * Returns true or false if subtopic exists within a topic.
   */
  private checkSubtopic() {
    const subtopic = (<HTMLInputElement>document.getElementById('subtopic')).value;
    for (let i = 0; i < this.subtopics.length; i++) {
      if (subtopic.toLowerCase() === this.subtopics[i].toLowerCase()) {
        this.validSubtopic = true;
        break;
      } else {
        this.validSubtopic = false;
      }
    }
  }

  /**
   * Returns true if all inputs are valid.
   */
  private validateInputs(): boolean {
    if (this.isDateValid(this.date.getTime())) {
      if (this.validSubtopic) {
        return true;
      }
    }
    return false;
  }

  /**
   * Adds subtopic to calendar
   */
  private addToCalendar() {
    const event = {
      title: 'Test1',
      start: new Date(),
      description: 'This is a cool event',
      textColor: 'white',
      color: eventColor.blue
    };

    if (this.validateInputs()) {
      const title = <HTMLInputElement>document.getElementById('subtopic');
      this.date = this.updateTime(this.date, this.time);

      event.title = title.value;
      event.start = this.date;
      event.description = `Subtopic for: ${event.title}`;
      this.events.push(event);

      $('#main-calendar').fullCalendar( 'renderEvent', event, true );
    }
  }

}

const eventColor = {
  red: '#ff0000',
  green: '#00bb5d',
  blue: '#2399e5',
  orange: '#fd7850'
};
