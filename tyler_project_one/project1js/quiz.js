var quizContainer;
var resultsContainer;
var submitButton;

window.onload = function () {
    quizContainer = document.getElementById('quiz');
    resultsContainer = document.getElementById('results');
    submitButton = document.getElementById('submit');


}

var questions = [
    {
        question: "Select the Square",
        answers: {
            a: "circle.png",
            b: "square.png",
            c: "triangle.png"
        },
        correctAnswer: 'b'
    },
    {
        question: "Select the Triangle",
        answers: {
            a: "triangle.png",
            b: "circle.png",
            c: "square.png"
        },
        correctAnswer: 'a'
    },
    {
        question: "Select the Star",
        answers: {
            a: "star.png",
            b: "square.png",
            c: "circle.png"
        },
        correctAnswer: 'a'
    },
    {
        question: "Select the One",
        answers: {
            a: "zero.png",
            b: "one.png",
            c: "nine.png"
        },
        correctAnswer: 'b'
    },
    {
        question: "Select the Nine",
        answers: {
            a: "nine.png",
            b: "one.png",
            c: "five.png"
        },
        correctAnswer: 'a'
    },
    {
        question: "Select the Five",
        answers: {
            a: "five.png",
            b: "nine.png",
            c: "zero.png"
        },
        correctAnswer: 'a'
    },
    {
        question: "Select the BLUE Fish",
        answers: {
            a: "redfish.png",
            b: "greenfish.png",
            c: "bluefish.png"
        },
        correctAnswer: 'c'
    },    {
        question: "Select the GREEN fish",
        answers: {
            a: "greenfish.png",
            b: "bluefish.png",
            c: "yellowfish.png"
        },
        correctAnswer: 'a'
    },    {
        question: "Select the YELLOW fish",
        answers: {
            a: "redfish.png",
            b: "yellowfish.png",
            c: "bluefish.png"
        },
        correctAnswer: 'b'
    },
];
var numCorrect;
function generateQuiz() {



    function showQuestions() {
        // store quiz output and answer choices
        var output = [];
        var answers;

        for (var i = 0; i < questions.length; i++) {
            // reset the list of answers
            answers = [];

            for (letter in questions[i].answers) {
                // add radio button
                answers.push(
                    '<label>'
                    + '<input type = "radio" name = "question' + i + '" value= " ' + letter + '">'
                    + letter + ': '
                    + '<img src = "'+questions[i].answers[letter]+'">'
                    + '</label>'
                );
            }
            // add this question and answers to the output

            output.push(
                '<div class="question">' + questions[i].question + '</div>'
                + '<div class= "answers">' + answers.join('') + '</div>'
            );
        }

        // output list to string and display on page

        quizContainer.innerHTML = output.join('');
    }
    
    function showResults() {
        // gather answer containers
        var answerContainers = quizContainer.querySelectorAll('.answers');
        // track users answers
        var userAnswer = '';
        numCorrect = 0;

        // for each question

        for (var i = 0; i < questions.length; i++) {
            userAnswer = (answerContainers[i].correctAnswer)
            // add to number of correct answers
            numCorrect++;

        }
        // show number correct out of total
        resultsContainer.innerHTML = numCorrect + 'out of' + questions.length;

    }

    showQuestions();

    submitButton.onclick = function () {
        showResults();
    }

}


function submitScoreFunction(){


let url= 'http://localhost:3001/quiz';
document.getElementById('results');

let data = {
    "score": numCorrect + 'out of' + questions.length,
    
}

fetch(url, {
    method: 'POST', 
    body: JSON.stringify(data), 
    headers:{
      'Content-Type': 'application/json'
    }
}).then(data=> data.json()).then(q => {
        console.log(q);
    // newQuestionStatus.innerHTML = q.question + " " + q.answer;
});


}

var trackedScores = null;

callScores();

function callScores(){
    let url= 'http://localhost:3001/quiz';

    fetch(url).then((resp) => {
        return resp.json();
    }).then((data)=> {
        console.log(data);
        trackedScores = data;
        showScores(trackedScores);
    })
}

function showScores(s) {
    console.log('set scores to page');
    console.log(s);
    for (i = 0; i < s.length; i++) {
        var li = document.createElement("li");
        li.appendChild(document.createTextNode(s[i].score));
        document.getElementById("scoreList").appendChild(li);
    }
}


