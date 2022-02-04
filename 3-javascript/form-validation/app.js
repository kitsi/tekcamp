const app = document.querySelector('#secondary-flex');
console.log(app);

buildPage();

function buildPage() {
  emptyFormFieldError();
}

function emptyFormFieldError() {
  const inputFields = document.querySelectorAll('form input');
  console.log(inputFields);
  inputFields.forEach(function(field){
    console.log(field);
    field.addEventListener('submit', function(e){
      // if(field.value ===''){
      //   let fieldName = field.name;
      //   console.log(fieldName);
      // }
    });
  });
}