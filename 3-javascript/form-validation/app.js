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
      }
    });
  });
}

function validateEmail() {
  submitButton.addEventListener('click', function(){
    let emailInput = emailField.value;
    console.log(emailInput);
    let expression = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let isValid = expression.test(String(emailInput).toLowerCase());
    if(!isValid){
      console.log('email not valid');
    } else {
      console.log('good');
    }
  });
}