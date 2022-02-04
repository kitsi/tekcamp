const faqList = document.querySelectorAll('.question');

buildPage();

function buildPage() {
  toggleAnswer();
}

function toggleAnswer() {
  faqList.forEach((question) => {
    console.log(question);
    question.addEventListener('click', (event) => {
      if(event.target.classList.contains('question')) {
        let answer = event.target.parentNode.querySelector('.answer');
        console.log(answer.style.display);
        if(answer.style.display === '') {
          answer.style.display = 'block';
        } else {
          answer.style.display === '';
        }
      }
    })
  });
}