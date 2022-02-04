buildPage();

function buildPage() {
  emptyInputFieldError();
}

function emptyInputFieldError() {
  const inputFields = document.querySelectorAll('form input');
  const submitButton = document.querySelector('#form-submit');
  inputFields.forEach(function(field){
    submitButton.addEventListener('click', function(){
      if(field.value ===''){
        let errorIcon = field.previousElementSibling;
        errorIcon.style.visibility = 'visible';
        let errorMessage = field.nextElementSibling;
        errorMessage.style.visibility = 'visible';
      }
    });
  });
}