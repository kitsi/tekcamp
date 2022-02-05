const inputFields = document.querySelectorAll('form input'),
      submitButton = document.querySelector('#form-submit');

displayEmptyInputFieldError();

function displayEmptyInputFieldError() {
  inputFields.forEach(function(field){
    let errorIcon = field.previousElementSibling;
    let errorMessage = field.nextElementSibling;
    submitButton.addEventListener('click', () => {
      removeActiveState(field, errorIcon, errorMessage);
      if(field.value ===''){
        errorIcon.style.visibility = 'visible';
        errorMessage.style.visibility = 'visible';
        errorMessage.style.fontStyle = 'italic';
        field.classList.add('error'); //changes border to red
        field.placeholder = '';
      } else if (field.id === 'email') {
        validateEmail(field);
      }
    });
  });
}

function validateEmail(emailField) {
  let emailInput = emailField.value;
  let errorIcon = emailField.previousElementSibling;
  let errorMessage = emailField.nextElementSibling;
    let expression = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let isValid = expression.test(String(emailInput).toLowerCase());
    if(emailField.value != '' && !isValid){
      errorIcon.style.visibility = 'visible';
      errorMessage.style.visibility = 'visible';
      errorMessage.innerText = 'Please enter a valid email address';
      emailField.classList.add('invalid-email'); //changes border & text to red
    }
}

function removeActiveState(inputField, errorIcon, errorMessage) {
  inputField.className = 'text-input';
  errorIcon.style.visibility = 'hidden';
  errorMessage.style.visibility = 'hidden';
}