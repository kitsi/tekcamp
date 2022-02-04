const faqList = document.querySelectorAll('.question');

buildPage();

function buildPage() {
  showAnswer();
  // hideAnswer();
}

function showAnswer() {
  faqList.forEach(function(question) {
    console.log(question);
    question.addEventListener('click', (event) => {
      if(event.target.classList.contains('question')) {
        let answer = event.target.parentNode.querySelector('.answer');
        console.log(answer);
      }
    })
  });
}