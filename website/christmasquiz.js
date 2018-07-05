function generateQuiz(questions, quizContainer, resultsContainer, submitButton){

    function showQuestions(questions, quizContainer){
        //code will go here
    }
    function showResults{questions, quizContainer, resultsContainer){
        // code
    }
    showQuestions(questions, quizContainer);
    //user clicks submit, show results

    submitButton.onclick = function(){
        showResults(questions, quizContainer, resultsContainer);

    }
}

var myQuestions = [
    {
        question: "Who is Father Christmas?"
        
        answers: {
            a: 'Elon Musk',
            b: 'George Bush',
            c: 'My Dad',
            d: 'Nicolas Claus'
        },
        correctAnswer: 'd'
    },
    {
        question: "Which reindeer leads the sleigh on Christmas?"
        
        answers: {
            a: 'Hachikō',
            b: 'Airbud',
            c: 'Rudolf',
            d: 'Blitzen'
        },
        correctAnswer: 'c'
    },
    {
        question: "When was the first recorded Christmas??"
        
        answers: {
            a: '0336 A.D.',
            b: '0033 B.C.',
            c: '1776 A.D.',
            d: '2012 A.D.'
        },
        correctAnswer: 'a'
    }
]

function showQuestions(questions, quizContainer){
    //a place to store output and answer choices
    var output = [];
    var answers;

    // for each question...

    for(var i=0; i<questions.length; i++){

        answers = [];

        for(letter in questions[i].answers){

            // ...add an html radio button
            
			answers.push(

				'<label>'
					+ '<input type="radio" name="question'+i+'" value="'+letter+'">'
					+ letter + ': '
					+ questions[i].answers[letter]
				+ '</label>'
			);
		}

		// add this question and its answers to the output
		output.push(
			'<div class="question">' + questions[i].question + '</div>'
			+ '<div class="answers">' + answers.join('') + '</div>'
		);
	}

    }
    quizContainer.innerHTML = output.join('');

    showQuestions(questions, quizContainer);
}

function showResults(questions, quizContainer, resultsContainer){
	
	// gather answer containers from our quiz
	var answerContainers = quizContainer.querySelectorAll('.answers');
	
	// keep track of user's answers
	var userAnswer = '';
	var numCorrect = 0;
	
	// for each question...
	for(var i=0; i<questions.length; i++){

		// find selected answer
		userAnswer = (answerContainers[i].querySelector('input[name=question'+i+']:checked')||{}).value;
		
		// if answer is correct
		if(userAnswer===questions[i].correctAnswer){
			// add to the number of correct answers
			numCorrect++;
			
			// color the answers green
			answerContainers[i].style.color = 'lightgreen';
		}
		// if answer is wrong or blank
		else{
			// color the answers red
			answerContainers[i].style.color = 'red';
		}
	}

	// show number of correct answers out of total
	resultsContainer.innerHTML = numCorrect + ' out of ' + questions.length;
}
// on submit, show results
submitButton.onclick = function(){
	showResults(questions, quizContainer, resultsContainer);
}

var quizContainer = document.getElementById('quiz');
var resultsContainer = document.getElementById('results');
var submitButton = document.getElementById('submit');

generateQuiz(myQuestions, quizContainer, resultsContainer, submitButton);
