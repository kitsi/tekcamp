const faqList = document.querySelectorAll('.question');

toggleAnswer();

function toggleAnswer() {
  faqList.forEach((question) => {
    question.addEventListener('click', (event) => {
      let answer;
      if(event.target.classList.contains('question')) {
        answer = event.target.parentNode.querySelector('.answer');
      } else if(event.target.classList.contains('arrow-icon')) {
        answer = event.target.parentNode.parentNode.querySelector('.answer');
      }
      if(answer.style.display === '') {
        answer.style.display = 'block';
      } else {
        answer.style.display = '';
      }
    })
  });
}