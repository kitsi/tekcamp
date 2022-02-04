const inputFields = document.querySelectorAll('form input'),
      emailField = document.querySelector('form input#email'),
      submitButton = document.querySelector('#form-submit');

buildPage();

function buildPage() {
  emptyInputFieldError();
  validateEmail();
}

function emptyInputFieldError() {
  inputFields.forEach(function(field){
    submitButton.addEventListener('click', function(){
      if(field.value ===''){
        let errorIcon = field.previousElementSibling;
        errorIcon.style.visibility = 'visible';
        let errorMessage = field.nextElementSibling;
        errorMessage.style.visibility = 'visible';
        field.classList.add('error');
        field.placeholder = '';
      }
    });
  });
}

function validateEmail() {
  submitButton.addEventListener('click', function(){
    let emailInput = emailField.value;
    let expression = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let isValid = expression.test(String(emailInput).toLowerCase());
    if(!isValid){
      let errorIcon = emailField.previousElementSibling;
      errorIcon.style.visibility = 'visible';
      let errorMessage = emailField.nextElementSibling;
      errorMessage.style.visibility = 'visible';
      errorMessage.innerText = 'Please enter a valid email address';
      emailField.className = 'invalid-email';
    }
  });
}