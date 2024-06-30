For delete item in javascript with an API call, run this function:
(async function deletePhoto(id) {
    await fetch('http://127.0.0.1:8080/photos/' + id, {
    method: "DELETE"
})})("5");

