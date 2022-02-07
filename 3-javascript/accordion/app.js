const faqList = document.querySelectorAll('.question');

toggleAnswer();

function toggleAnswer() {
  faqList.forEach((listItem) => {
    listItem.addEventListener('click', (event) => {
      let question;
      let answer;
      if(event.target.classList.contains('question')) {
        question = event.target.parentNode.querySelector('.question');
        answer = event.target.parentNode.querySelector('.answer');
      } else if(event.target.classList.contains('arrow-icon')) {
        question = event.target.parentNode;
        answer = event.target.parentNode.parentNode.querySelector('.answer');
      }
      if(answer.style.display === '') {
        answer.style.display = 'block';
        question.style.fontWeight = 'bold';
      } else {
        answer.style.display = '';
        question.style.fontWeight = 'normal';
      }
    });
  });
}