const app = document.querySelector('#secondary-flex');
// console.log(app);

buildPage();

function buildPage() {
  emptyFormFieldError();
}

function emptyFormFieldError() {
  const inputFields = document.querySelectorAll('form input');
  const submitButton = document.querySelector('#form-submit');
  // console.log(inputFields);
  console.log(submitButton);
  inputFields.forEach(function(field){
    // console.log(field);
    // console.log(field.name);
    submitButton.addEventListener('click', function(){
      if(field.value ===''){
        console.log(field.name);
      }
    });
  });
}