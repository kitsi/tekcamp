buildPage();

function buildPage() {
  emptyFormFieldError();
}

function emptyFormFieldError() {
  const inputFields = document.querySelectorAll('form input');
  console.log(inputFields);
  const submitButton = document.querySelector('#form-submit');
  console.log(submitButton);
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