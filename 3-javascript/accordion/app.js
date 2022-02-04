const faqList = document.querySelectorAll('.question');

toggleAnswer();

function toggleAnswer() {
  faqList.forEach((question) => {
    question.addEventListener('click', (event) => {
      if(event.target.classList.contains('question')) {
        let answer = event.target.parentNode.querySelector('.answer');
        console.log(answer.style.display);
        if(answer.style.display === '') {
          answer.style.display = 'block';
        } else {
          answer.style.display = '';
        }
      }
    })
  });
}